package com.ncr.banking.services.dbkniiscdiis;

import com.ncr.banking.services.dbkniiscdiis.mock.MockConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource( locations = {"/diis-test.properties","/application-test.properties"})
@TestPropertySource(properties = {"management.port=0"})
class DbkNiisDiisClientApplicationTests {

	@LocalServerPort
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Autowired
	private TestRestTemplate testRestTemplate;


	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Get actuator/info returns HttpStatus 200")
	public void shouldReturn200WhenSendingRequestToManagementEndpoint() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.mgt + "/actuator/info", Map.class);

		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}



	@Test
	@DisplayName("Get actuator/health returns HttpStatus 200 and status UP")
	void healthDefault() {
		// http://localhost:8080/actuator/health
		/*
		{
		"status": "UP",
		"components": {
			"broker": {
				"status": "UP"
			},
			"diskSpace": {
				"status": "UP",
				"details": {
					"total": 500068036608,
					"free": 154737135616,
					"threshold": 10485760,
					"exists": true
				}
			},
			"livenessState": {
				"status": "UP"
			},
			"ping": {
				"status": "UP"
			},
			"readinessState": {
				"status": "UP"
			}
		},
		"groups": [
			"liveness",
			"readiness"
		]
	}
		 */
		ResponseEntity<String> entity = this.testRestTemplate.getForEntity("/actuator/health", String.class);
		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(entity.getBody()).contains("\"status\":\"UP\"");
		Assertions.assertThat(entity.getBody()).doesNotContain("\"hello\":\"1\"");
	}


	// liveness probe http://localhost:8080/actuator/health/liveness
	@Test
	@DisplayName("Get actuator/health/liveness returns HttpStatus 200")
	public void livenessProbeShouldReturnUp() {

		ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.mgt + MockConstants.LIVENESS_URL, String.class);

		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(entity.getBody()).contains("\"status\":\"UP\"");

	}

	// readiness : http://localhost:8080/actuator/health/readiness
	@Test
	@DisplayName("Get actuator/health/readiness returns HttpStatus 200")
	public void readinessProbeShouldReturnUp() {

		ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.mgt + MockConstants.READINESS_URL, String.class);

		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(entity.getBody()).contains("\"status\":\"UP\"");

	}

	@Test
	@SuppressWarnings("unchecked")
	@DisplayName("Get actuator/metrics returns metric names")
	@Disabled("add back when add transactions")
	void metricsShouldReturnNames() throws NullPointerException{
		/*

		// http://localhost:8080/actuator/metrics
		{
			"names": [
			"http.server.requests",
					"jvm.buffer.count",
					"jvm.buffer.memory.used",
					"jvm.buffer.total.capacity",
					"jvm.classes.loaded",
					"jvm.classes.unloaded",
					"jvm.gc.live.data.size",
					"jvm.gc.max.data.size",
					"jvm.gc.memory.allocated",
					"jvm.gc.memory.promoted",
					"jvm.gc.pause",
					"jvm.memory.committed",
					"jvm.memory.max",
					"jvm.memory.used",
					"jvm.threads.daemon",
					"jvm.threads.live",
					"jvm.threads.peak",
					"jvm.threads.states",
					"logback.events",
					"niis.v1.transactions",
					"niis.v1.transactions.time",
					"process.cpu.usage",
					"process.files.max",
					"process.files.open",
					"process.start.time",
					"process.uptime",
					"system.cpu.count",
					"system.cpu.usage",
					"system.load.average.1m"
   				 ]

		 */
		//testHome();
		ResponseEntity<Map<String, Object>> entity = asMapEntity(
				this.testRestTemplate.getForEntity(MockConstants.METRICS_URL, Map.class));
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody()).containsKey("names");
		List<String> names = (List<String>) entity.getBody().get("names");
		assertThat(names).isNotNull();
		assertThat(names).contains("jvm.buffer.count");
		assertThat(names).contains("niis.v1.transactions");
		assertThat(names).contains("niis.v1.transactions.time");
	}


	@Test
	@DisplayName("Get actuator returns _links and HttpStatus 200")
	public void actuatorShouldReturnActuatorEndpoints() {

		// http://localhost:8080/actuator/
		/*{
		"_links": {
			"self": {
				"href": "http://localhost:8080/actuator",
				"templated": false
			},
			"health": {
				"href": "http://localhost:8080/actuator/health",
				"templated": false
			},
			"health-path": {
				"href": "http://localhost:8080/actuator/health/{*path}",
				"templated": true
			},
			"info": {
				"href": "http://localhost:8080/actuator/info",
				"templated": false
			},
			"metrics-requiredMetricName": {
				"href": "http://localhost:8080/actuator/metrics/{requiredMetricName}",
				"templated": true
			},
			"metrics": {
				"href": "http://localhost:8080/actuator/metrics",
				"templated": false
			}
		}

		 */

		ResponseEntity<String> entity = this.testRestTemplate.getForEntity(
				"http://localhost:" + this.mgt + MockConstants.ACTUATOR_URL, String.class);

		Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

		assertThat(entity.getBody()).contains("\"self\":{", "\"href\":\"http://localhost:" + this.mgt + "/actuator\"", "\"templated\":false");
		assertThat(entity.getBody()).contains("\"health\":{");
		assertThat(entity.getBody()).contains("\"info\":{");
		assertThat(entity.getBody()).contains("\"metrics\":{");


	}



	// http://localhost:8080/actuator/info
	// {
	//    "app": {
	//        "name": "dbk-niis-c-diis",
	//        "description": "NIIS DIIS Connector",
	//        "version": "0.0.1"
	//    }
	//}



	@SuppressWarnings({ "unchecked", "rawtypes" })
	static <K, V> ResponseEntity<Map<K, V>> asMapEntity(ResponseEntity<Map> entity) {
		return (ResponseEntity) entity;
	}
}
