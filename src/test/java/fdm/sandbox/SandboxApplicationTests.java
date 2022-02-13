package fdm.sandbox;

import fdm.sandbox.controllers.MainController;
import fdm.sandbox.domain.Parcel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SandboxApplicationTests {

	@Autowired
    private MainController mainController;

	@Test
	void contextLoads() {
        assert mainController != null;

		Parcel parcel = new Parcel();
		parcel.setParcelNumber("1234");
		parcel.setParcelBarcode("123");

		ResponseEntity<?> responseEntity = mainController.postParcel(parcel);

		assert responseEntity.getStatusCode().value() == 200;
	}

}
