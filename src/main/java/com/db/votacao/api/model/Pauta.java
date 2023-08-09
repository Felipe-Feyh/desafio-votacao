package com.db.votacao.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = Pauta.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pauta {

    public static final String TABLE_NAME = "pauta";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pauta", unique = true)
    private UUID idPauta;

    @Column(name = "titulo_pauta", nullable = false, length = 150)
    private String dsTituloPauta;

    @Column(name = "descricao_pauta", nullable = false)
    private String dsDescricaoPauta;

    @Column(name = "data_inicio_pauta", nullable = false)
    private LocalDateTime dtInicioPauta = LocalDateTime.now();

    public Pauta(@NonNull String dsTituloPauta, @NonNull String dsDescricaoPauta){
        this.dsTituloPauta = dsTituloPauta;
        this.dsDescricaoPauta = dsDescricaoPauta;
    }


}