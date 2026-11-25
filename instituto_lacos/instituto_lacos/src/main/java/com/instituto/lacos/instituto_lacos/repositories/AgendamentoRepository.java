package com.instituto.lacos.instituto_lacos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.instituto.lacos.instituto_lacos.models.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
@Query(value = "select ag.agendamento_id, ag.data, ag.crianca_id, ag.usuario_id, " +
               "p.nome_pretendente, p.cpf as pretendente_cpf from agendamento ag " +
               "inner join crianca cri on cri.crianca_id = ag.crianca_id " +
               "inner join pretendente p on p.pretendente_id = cri.pretendente_id " +
               "order by ag.data", nativeQuery = true) //Confirmar
        public List<Agendamento> listarAgendamentos();
}
