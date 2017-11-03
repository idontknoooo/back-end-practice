package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

public @Data @Embeddable @JsonInclude(JsonInclude.Include.NON_NULL)
class MedicalInfo {

    private Long bfr; // Blood Flow Rate
    private Long fmi; // First-aid Medical Index

    // Constructor
    public MedicalInfo(){

    }
    public MedicalInfo(Long bfr, Long fmi) {
        this.bfr = bfr;
        this.fmi = fmi;
    }

//    // Setter
//    public void setBfr(Long bfr) {
//        this.bfr = bfr;
//    }
//
//    public void setFmi(Long fmi) {
//        this.fmi = fmi;
//    }
//
//    // Getter
//    public Long getBfr() {
//
//        return bfr;
//    }
//
//    public Long getFmi() {
//        return fmi;
//    }
}
