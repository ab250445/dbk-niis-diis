package com.ncr.banking.services.dbkniisdiis.api.mapper;

import com.intuit.ifs.afeLibrary.broker.diis.msg.HistoryData;
import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.ncr.banking.services.dbkniisdiis.api.model.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.format.DateTimeFormatter;


public class TransactionMapper {
    static final Logger logger = LoggerFactory.getLogger(TransactionMapper.class.getName());


    public static List<Transaction> mapDiisMessage(Message message) {
         List<Transaction> transactions = null;

         if (message.getHDATA() != null) {
             transactions = message.getHDATA().stream()
                     .filter(historyData -> convertDateToOffsetDateTime(historyData.getTDT()) != null)
                     .filter((historyData -> historyData.getTTYP() != null))
                     .map(TransactionMapper::mapHistoryDataToTransaction)
                     .collect(Collectors.toList());
         }
         return transactions;

    }
    private static Transaction mapHistoryDataToTransaction(HistoryData historyData) {
        long ttyp = historyData.getTTYP();
        Transaction.TransactionTypeEnum typeEnum = Transaction.TransactionTypeEnum.UNKNOWN;
        if(ttyp >= 0 && ttyp <= 199) {
            typeEnum = Transaction.TransactionTypeEnum.DEBIT;
        } else if (ttyp >= 500 && ttyp <= 699) {
            typeEnum = Transaction.TransactionTypeEnum.CREDIT;
        }

        List<HostTransactionCode> hostTransactionCodes = new ArrayList<HostTransactionCode>();
        HostTransactionCode hostTransactionCode = new HostTransactionCode();
        hostTransactionCode.setType(HostTransactionCode.TypeEnum.HOST_TRANSACTION_CODE);
        hostTransactionCodes.add(hostTransactionCode);
        // create Message subclass

        List<HostTransactionId> hostTransactionIds = new ArrayList<HostTransactionId>();
        if(!historyData.getTNUM().isEmpty()) {
            HostTransactionId hostTransactionId = new HostTransactionId();
            hostTransactionId.setType(HostTransactionId.TypeEnum.HOST_TRANSACTION_ID);
            hostTransactionId.setValue(historyData.getTNUM());
        }

        List<TransactionAmount> transactionAmounts = new ArrayList<TransactionAmount>();

        if( (historyData.getTAMT() != null) && historyData.getTAMT() > 0) {
            if ((int) ttyp == 505) {
                transactionAmounts.add(createTransactionAmount(historyData.getTAMT(),
                        TransactionAmount.TypeEnum.DIVIDEND));
            } else {
                transactionAmounts.add(createTransactionAmount(historyData.getTAMT(),
                        TransactionAmount.TypeEnum.AMOUNT));
            }
        }

        if((historyData.getTFEE() != null) && historyData.getTFEE() > 0) {

            transactionAmounts.add(createTransactionAmount(historyData.getTFEE(),
                    TransactionAmount.TypeEnum.FEE));
        }

        if( (historyData.getLPRIN() != null) && historyData.getLPRIN() > 0) {
            transactionAmounts.add(createTransactionAmount(historyData.getLPRIN(),
                    TransactionAmount.TypeEnum.PRINCIPAL));
        }

        if( (historyData.getLINT() != null) && historyData.getLINT() > 0) {
            transactionAmounts.add(createTransactionAmount(historyData.getLINT(),
                    TransactionAmount.TypeEnum.INTEREST));
        }

        if( ( historyData.getLESCROW() != null) && historyData.getLESCROW() > 0) {

            transactionAmounts.add(createTransactionAmount(historyData.getLESCROW(),
                    TransactionAmount.TypeEnum.ESCROW));
        }

        hostTransactionCode = new HostTransactionCode();
        hostTransactionCode.setValue(historyData.getBAICODE());
        hostTransactionCode.setType(HostTransactionCode.TypeEnum.BAI_CODE);
        hostTransactionCodes.add(hostTransactionCode);


        List<BalanceAmount> balanceAmounts = new ArrayList<BalanceAmount>();

        if((historyData.getABAL() != null) && historyData.getABAL() > 0) {

            balanceAmounts.add(createBalanceAmount(historyData.getABAL(),
                    BalanceAmount.TypeEnum.LEDGER_BALANCE));
        }

       /* if(historyData.get > 0) { - not in afelibrary
            BalanceAmount balanceAmount = new BalanceAmount();
            amount = new Amount();
            amount.setAmount(Integer.parseInt(String.valueOf(historyData.getABAL())));
            amount.setCurrencyCode("USD");
            balanceAmount.setType(BalanceAmount.TypeEnum.LEDGER_BALANCE);
            balanceAmount.setValue(amount);
        }

        */
       List<Image> images = new ArrayList<Image>();

       if(historyData.getCHKNM() != null  && !historyData.getCHKNM().isEmpty()) {
           Image image = new Image();
           image.setLocation(historyData.getCKLOCAT());
           images.add(image);
       }

       List<HostAccountId> hostAccountIds = new ArrayList<HostAccountId>();
       if((historyData.getMICR() != null) && historyData.getMICR() > 0L) {
           HostAccountId hostAccountId = new HostAccountId();
           hostAccountId.setValue( String.valueOf( historyData.getMICR()));
           hostAccountId.setType(HostAccountId.TypeEnum.MICR);
           hostAccountIds.add(hostAccountId);
       }

        Transaction transaction = Transaction.builder()
                //.institutionId(message.getDIID())
                .transactionType(typeEnum)
                .transactionDate(convertDateToOffsetDateTime(historyData.getTDT()))
                .effectiveDate(convertDateToOffsetDateTime(historyData.getEDT()))
                .hostTransactionIds(hostTransactionIds)
                .description(historyData.getTDSC())
                .transactionAmounts(transactionAmounts)
                .memo(historyData.getMEMO())
                .images(images)
                .checkNumber(historyData.getCHKNM())
                .hostTransactionCodes(hostTransactionCodes)
                .hostAccountIds(hostAccountIds)
                .build();


        return transaction;
    }

    private static TransactionAmount createTransactionAmount(double tamt,  TransactionAmount.TypeEnum amtType) {
       TransactionAmount transactionAmount = TransactionAmount.builder()
                    .value(Amount.builder()
                            .amount((int) Math.round(100*tamt))
                            .currencyCode("USD")
                            .build())
                    .type(amtType)
                .build();

        return transactionAmount;
    }

    private static BalanceAmount createBalanceAmount(double tamt,  BalanceAmount.TypeEnum amtType) {
        BalanceAmount balanceAmount = BalanceAmount.builder()
                .value(Amount.builder()
                        .amount((int) Math.round(100*tamt))
                        .currencyCode("USD")
                        .build())
                .type(amtType)
                .build();

        return balanceAmount;
    }

    private static OffsetDateTime convertDateToOffsetDateTime(Date date) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if(calendar.get(Calendar.YEAR) < 1900) {
            return null;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        //logger.debug("Date ->{}<- string: {}",date, dateString);


        // what is offset +08:00
        String formattedDate = dateString + "T00:00:00+08:00";
        OffsetDateTime target = OffsetDateTime.parse(formattedDate, dateTimeFormatter);


        return target;
    }


}
