package com.ncr.banking.services.dbkniisdiis.api.mapper;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.ncr.banking.services.dbkniisdiis.api.model.*;

import java.util.*;

public class CustomerMapper  {

     public static Customer mapDiisMessage(Message message) {
        Customer customer = new Customer();

        if (message != null) {

            TaxId taxId = TaxId.builder()
                    .value(message.getTAXID())
                   // .type(message.getTAXIDTYPE().toString())
                    .build();

            PostalAddress postalAddress = PostalAddress.builder()
                    .streetAddress1(message.getUSRST())
                    .streetAddress2(message.getUSRST2())
                    .streetAddress3(message.getUSRST3())
                    .city(message.getUSRCITY())
                    .state(message.getUSRSTE())
                    .postalcode(message.getUSRZIP())
                    .country(message.getCOUNTRY())
                    .build();

            List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

            PhoneNumber phoneNumber1 = null;
            String phone1 = message.getPHONE();
            if(phone1 != null && !phone1.isEmpty() ) {
                phoneNumber1 = PhoneNumber.builder()
                        .number(phone1)
                        .countryCode(message.getPHONECOUNTRYCODE())
                        .build();
                phoneNumbers.add(phoneNumber1);
            }

            PhoneNumber phoneNumber2 = null;
            String phone2 = message.getPHONE3();
            if(phone2 != null && !phone2.isEmpty() ) {
                phoneNumber2 = PhoneNumber.builder()
                        .number(phone2)
                        .countryCode(message.getPHONE2COUNTRYCODE())
                        .build();
                phoneNumbers.add(phoneNumber2);
            }

            PhoneNumber phoneNumber3 = null;
            String phone3 = message.getPHONE3();

            if(phone3 != null && !phone3.isEmpty()) {
                phoneNumber3 = PhoneNumber.builder()
                        .number(phone3)
                        .countryCode(message.getPHONE3COUNTRYCODE())
                        .build();
                phoneNumbers.add(phoneNumber3);
            }

            phoneNumbers.add(phoneNumber1);

            List<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();

            EmailAddress emailAddress = EmailAddress.builder()
                    .email(message.getEMAIL())
                    .build();

            emailAddresses.add(emailAddress);

            Person person = Person.builder()
                   // .dateOfBirth(message.getBDATE().toString())
                    .emailAddresses(emailAddresses)
                    .fullName(message.getUSRNM())
                    .firstName(message.getFNAME())
                    .lastName(message.getLNAME())
                    .middleName(message.getMI())
                    .salutation(message.getNMPREFIX())
                    .mothersMaidenName(message.getMMNM())
                    .nickName(message.getSCNDNM())
                    .phoneNumbers(phoneNumbers)
                    .taxId(taxId)
                    .build();
            List<HostId> hostIdList = new ArrayList<HostId>();

            String cif = message.getCIF();
            if(cif != null && cif.isEmpty()) {
                HostId hostId = HostId.builder()
                        .value(cif)
                        .type(HostId.TypeEnum.CIF)
                        .build();
                hostIdList.add(hostId);
            }


            HostId hostId = HostId.builder()
                    .value(message.getUSR())
                    .type(HostId.TypeEnum.MEMBER_ID)
                    .build();
            hostIdList.add(hostId);


              customer = Customer.builder()
                    .institutionId(message.getDIID())
                    .hostIds(hostIdList)
                    .person(person)
                    .build();
         }
        return customer;


    }

}
