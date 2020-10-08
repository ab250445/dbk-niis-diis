package com.ncr.banking.services.dbkniisdiisc.handler;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import com.intuit.ifs.afeLibrary.broker.diis.msg.Message;
import com.intuit.ifs.afeLibrary.broker.diis.type.MessageType;
import com.ncr.banking.services.dbkniisdiis.api.model.Customer;
import com.ncr.banking.services.dbkniisdiis.api.model.Person;
import com.ncr.banking.services.dbkniisdiisc.config.ConfigProperties;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerPostRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerRequest;
import com.ncr.banking.services.dbkniisdiisc.model.CustomerResponse;
import com.ncr.banking.services.dbkniisdiisc.model.MessageResponse;
import com.ncr.banking.services.dbkniisdiisc.mapper.DiisCustomerMapper;
import com.ncr.banking.services.dbkniisdiisc.mock.MockConstants;
import com.ncr.banking.services.dbkniisdiisc.mock.MockUtil;
import com.ncr.banking.services.dbkniisdiisc.repository.CustomerDiisRepository;
import com.ncr.banking.services.dbkniisdiisc.util.diis.DIISDataSourceCreator;
import com.ncr.banking.services.dbkniisdiisc.util.diis.DiisTemplate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@AutoConfigureWebTestClient
@SpringBootTest
@TestPropertySource("/diis-test.properties")
@EnableConfigurationProperties(value = ConfigProperties.class)
@ContextConfiguration(classes = ConfigProperties.class)
public class CustomerHandlerTest {

    static final Logger logger = LoggerFactory.getLogger(CustomerHandlerTest.class.getName());

    @Autowired
    private static  DiisCustomerMapper diisCustomerMapper;

    @MockBean
    private DiisTemplate diisTemplate;

    @Autowired
    private ConfigProperties configProperties;


    @MockBean
    private DIISDataSourceCreator dataSourceCreator;

    @InjectMocks
    private CustomerDiisRepository customerDiisRepository;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeAll
    public static void init() {
        diisCustomerMapper = Mappers.getMapper(DiisCustomerMapper.class);
      }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMonoEndpoint() {
        Flux<String> msg$ = webTestClient.get()
                .uri("/")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .returnResult(String.class).getResponseBody()
                .log();
        StepVerifier.create(msg$)
				.expectNext(MockConstants.TEST_MESSAGE)
                .verifyComplete();

    }


    @Test
    @Disabled
    // not working when not using diistemplatefactory
    public void testPostMessage() {


         CustomerRequest customerRequest = MockUtil.createCustomerRequest();

        // mock customer response
        Customer customer = Customer.builder()
                .id("1")
                .institutionId(MockConstants.INSTITUTION_ID)
                .person( Person.builder()
                        .firstName("Jane")
                        .lastName("Doe")
                        .fullName("Jane Doe")
                        .build())
                .hostIds(MockUtil.createHostIdList())
                .build();

        CustomerResponse customerResp = MockUtil.createCustomerResponse();

        Message messageResponse = MockUtil.createMessageResponse(MockConstants.HOSTID, MessageType.USRVER);

         Mono<CustomerResponse> customerResponseMono = Mono.just(customerResp);
     //   DiisDataSource dataSource;
      //  dataSource = new DiisDataSource("host", 3450);

       // when(dataSourceCreator.getDataSource()).thenReturn(dataSource);
      //  when(diisTemplate.execute(MockUtil.createMessageRequest(MessageType.USRVER))).thenReturn(messageResponse);
        when(diisTemplate.execute(any(Message.class))).thenReturn(messageResponse);

        //   when(diisTemplate.execute(any(Message.class))).thenReturn(this.createSinglePageTransactionsResponse());

       // when(customerDiisRepository.executeDiis(MockUtil.createMessageRequest(MessageType.USRVER),
         //    "testhost",eq("testport"))).thenReturn(messageResponse);

        webTestClient.post()
                .uri("/niis/v1/customer?action=userVerify")
                .contentType(MediaType.APPLICATION_JSON)
               // .accept(MediaType.ALL)
                .accept(MediaType.APPLICATION_JSON)
               // .header("Content-Type", "application/json")
               // .header("serviceType", "INTERNET_BANKING")
                .header("serviceType", "INTERNET_BANKING")
                .header("broker-host", "brokersim.dev1.diginsite.net")
                .header("broker-port", "80")
                .body(Mono.just(MockUtil.createCustomerPostRequest()), CustomerPostRequest.class)
                .exchange()
                .expectStatus().isOk()
                //.expectHeader().exists("tmhost")
                .expectBody(Customer.class);
                //.returnResult(CustomerResponse.class).getResponseBody()
                //.log();

                /*.value(customerResponse -> {
                    Assertions.assertThat(customerResponse.getId()).isEqualTo("1");
                    Assertions.assertThat(customerResponse.getInstitutionId()).isEqualTo("1234");
                    Assertions.assertThat(customerResponse.getPerson().getFullName()).isEqualTo("Jane Doe");
                    Assertions.assertThat(customerResponse.getPerson().getFirstName()).isEqualTo("Jane");
                    Assertions.assertThat(customerResponse.getPerson().getLastName()).isEqualTo("Doe");
                    Assertions.assertThat(customerResponse.getHostIds().size()).isEqualTo(1);
                    Assertions.assertThat(customerResponse.getHostIds().get(0).getType()).isEqualByComparingTo(HostId.TypeEnum.MEMBER_ID);
                    Assertions.assertThat(customerResponse.getHostIds().get(0).getValue()).isEqualTo("8390022");
                   // Assertions.assertThat(customerResponse.getErrorInfo()).isNull();
                   // Assertions.assertThat(customerResponse.getHeaders()).isNull();
                }); */


    }
    @Test
    @Disabled
    public void testGetMessageResponse() {


        CustomerPostRequest customerPostRequest = MockUtil.createCustomerPostRequest();
        CustomerRequest customerRequest = MockUtil.createCustomerRequest();

        // mock customer response
        Customer customer = Customer.builder()
                .id("1")
                .institutionId(MockConstants.INSTITUTION_ID)
                .person( Person.builder()
                        .firstName("Jane")
                        .lastName("Doe")
                        .fullName("Jane Doe")
                        .build())
                .hostIds(MockUtil.createHostIdList())
                .build();

        CustomerResponse customerResp = MockUtil.createCustomerResponse();

        Message messageResponse = MockUtil.createMessageResponse(MockConstants.HOSTID, MessageType.USRVER);

      //     dataSource = new DiisDataSource(host, port);
      //  DiisDataSource dataSource;
     //   dataSource = new DiisDataSource("host", 3450);

       // when(dataSourceCreator.getDataSource()).thenReturn(dataSource);
        //when(diisTemplate.execute(MockUtil.createMessageRequest(MessageType.USRVER))).thenReturn(message);
        //when(customerDiisRepository.executeDiis(MockUtil.createMessageRequest(MessageType.USRVER),anyString(),anyString())).thenReturn(messageResponse);
        when(diisTemplate.execute(any(Message.class))).thenReturn(messageResponse);


       // when(customerDiisRepository.getMessage(any(CustomerRequest.class)).thenReturn(messageResponseMono));

          webTestClient.post()
                .uri("/niis/v1/message")
                 .contentType(MediaType.APPLICATION_JSON)
                // .accept(MediaType.ALL)
                 .accept(MediaType.APPLICATION_JSON)
                  .header("serviceType", "INTERNET_BANKING")
                  .header("broker-host", "brokersim.dev1.diginsite.net")
                  .header("broker-port", "80")
                  .body(Mono.just(customerPostRequest), CustomerPostRequest.class)
                .exchange()
                .expectStatus().isOk()
                //.expectHeader().exists("tmhost")
                // .returnResult(MessageResponse.class).getResponseBody()
                 //.log();

               .expectBody(MessageResponse.class)
                .value(response -> {
                    Assertions.assertThat(response.getMessage().getRSP()).isEqualTo(MessageType.USRVER);
                 });
               // .returnResult(Message.class).getResponseBody()
              //  .log();


    }
    @Test
    public void testCreateMessage() {
        CustomerPostRequest customerPostRequest = MockUtil.createCustomerPostRequest();

        //Mono<Message> messageMono = Mono.just(createMessageResponse(MockConstants.HOSTID, MessageType.USRVER));


        //when(customerDiisRepository.createMessage(customerRequest)).thenReturn(messageMono);

        webTestClient.post()
                .uri("/niis/v1/message/create")
                .contentType(MediaType.APPLICATION_JSON)
                // .accept(MediaType.ALL)
                // .accept(MediaType.APPLICATION_JSON)
                // .header("Content-Type", "application/json")
                .header("serviceType", "INTERNET_BANKING")
                .body(Mono.just(customerPostRequest), CustomerPostRequest.class)
                .exchange()
                .expectStatus().isOk()
                //.expectHeader().exists("tmhost")
                .expectBody(Message.class)
                .value(response -> {
                    Assertions.assertThat(response).isNotNull();
                    Assertions.assertThat( response.getREQ()).isEqualTo(MessageType.USRVER);
                  });              // .log();


    }


    /*
    @Test
    @Ignore
    public void testGetCustomer() {

        HostId hostId = HostId.builder()
                .type(HostId.TypeEnum.MEMBER_ID)
                .value("8390022")
                .build();
        List<HostId> hostIds = new ArrayList<HostId>();
        hostIds.add(hostId);

        CustomerPostRequest customerPostRequest = CustomerPostRequest.builder()
                .hostIds(hostIds)
                .institutionId("1234")
                .build();

        CustomerRequest customerRequest = CustomerRequest.builder()
                .customerPostRequest(customerPostRequest)
                .serviceType( (ServiceType.IB).getDescription())
                .build();

        // mock customer response
        Customer customer = Customer.builder()
                .id("1")
                .institutionId("1234")
                .person( Person.builder()
                        .firstName("Jane")
                        .lastName("Doe")
                        .fullName("Jane Doe")
                        .build())
                .hostIds(hostIds)
                .build();

        CustomerResponse customerResp = CustomerResponse.builder()
                .customer(customer)
                .build();


        Mono<CustomerResponse> customerResponseMono = Mono.just(customerResp);

        when(customerDiisRepository.getCustomer(any())).thenReturn(customerResponseMono);

        webTestClient.get()
                .uri("/niis/v1/customer?institutionId=1234&hostType=9999")
                //.contentType(MediaType.APPLICATION_JSON)
                // .accept(MediaType.ALL)
                 .accept(MediaType.APPLICATION_JSON)
                // .header("Content-Type", "application/json")
                .header("serviceType", "INTERNET_BANKING")
                 .exchange()
                .expectStatus().isOk()
                //.expectHeader().exists("tmhost")
                .expectBody(Customer.class)
                .value(customerResponse -> {
                    Assertions.assertThat(customerResponse.getId()).isEqualTo("1");
                    Assertions.assertThat(customerResponse.getInstitutionId()).isEqualTo("1234");
                    Assertions.assertThat(customerResponse.getPerson().getFullName()).isEqualTo("Jane Doe");
                    Assertions.assertThat(customerResponse.getPerson().getFirstName()).isEqualTo("Jane");
                    Assertions.assertThat(customerResponse.getPerson().getLastName()).isEqualTo("Doe");
                    Assertions.assertThat(customerResponse.getHostIds().size()).isEqualTo(1);
                    Assertions.assertThat(customerResponse.getHostIds().get(0).getType()).isEqualByComparingTo(HostId.TypeEnum.MEMBER_ID);
                    Assertions.assertThat(customerResponse.getHostIds().get(0).getValue()).isEqualTo("8390022");
                    // Assertions.assertThat(customerResponse.getErrorInfo()).isNull();
                    // Assertions.assertThat(customerResponse.getHeaders()).isNull();
                });


    }
    */
}
