package fdm.sandbox.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Parcel {

    @NotBlank
    private String parcelNumber;

    @Size(max = 3)
    private String parcelBarcode;
}
