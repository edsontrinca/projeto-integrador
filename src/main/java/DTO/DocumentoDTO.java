package DTO;

import lombok.Data;

public class DocumentoDTO {

    @Data

    public class Documento {
        private String cpf;
        private String cnpj;
        private String identidade;
    }
}
