## Projeto V

<details>
  
<summary>
	Mais Detalhes do Projeto V
</summary>

# DataViz - Sistema de análise de dados de recrutamento e seleção. Tem como objetivo oferecer insights valiosos

### Parceiro Acadêmico
	
<br/>

![image]([https://pro4tech.com.br/assets/img/logo-p4t-navbar-branco.png](https://pro4tech.com.br/assets/img/logo-p4t-navbar-branco.png))

##### *Figura 01. Logo Pro4Tech Fonte([Subiter](https://pro4tech.com.br/))*

### Visão do Projeto

Neste projeto, foi proposta a implementação de um sistema para otimizar a maneira como os dados de recrutamento são coletados, visualizados e analisados visando centralizar e visualizar dados dispersos, permitir uma tomada de decisão estratégica, gerar relatórios personalizados e automatizar processos manuais, além de possibilitar a integração de dados de diferentes fontes.

O foco principal do projeto é fornecer insights valiosos a partir de métricas de eficiência no recrutamento (ex. tempo médio de contratação, quantidade de contratações por processo seletivo).
Identificação de padrões e tendências para otimizar o processo de seleção.
Personalização de relatórios conforme as necessidades específicas dos gestores.

### Tecnologias adotadas na solução

<div style="text-align: center;">
  <div style="margin-top: 10px; font-weight: bold;">BackEnd</div>
  <div style="display: inline_block">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original-wordmark.svg" width="85" height="85" />
    <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original-wordmark.svg" width="85" height="85" />
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/apachespark/apachespark-original.svg" width="85" height="85" />
  </div>
</div>
<div style="text-align: center;">
  <div style="margin-top: 10px; font-weight: bold;">FrontEnd</div>
  <div style="display: inline_block">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/vuejs/vuejs-original.svg" width="85" height="85" />
  </div>
</div>
<div style="text-align: center;">
  <div style="margin-top: 10px; font-weight: bold;">Banco de Dados</div>
  <div style="display: inline_block">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original.svg" width="85" height="85" />
  </div>
</div>

## Iniciativas Implementadas

 - Tive uma participação ativa na modelagem do esquema estrela do banco de dados, a partir das necessidades do cliente
![image](https://github.com/user-attachments/assets/86838ff8-31cb-44c8-a80c-72fb44585aaa)

    
<details open><summary>Informações sobre a implementação de importação dos dados do cliente para o banco de dados</summary>
     
   ```java
		public void Salvar(String arquivo){

		Dataset<Row> dadosPlanilha = spark
				.read()
				.format("csv")
				.option("header", true)
				.option("delimiter", ";")
				.load(arquivo);


		var dadosPlanilhaTratados = dadosPlanilha
		.withColumn("idTempo", functions.row_number().over(Window.orderBy("idProcessoSeletivo")))
        .withColumn("mes", functions.month( functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")))
		.withColumn("ano", functions.year( functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")))
        .withColumn("semestre", functions.when(
        		functions.month(functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")).between(1, 6), 1)
        		.when(functions.month(functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")).between(7, 12), 2))
        .withColumn("trimestre", functions.when(
        		functions.month(functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")).between(1, 4), 1)
        		.when(functions.month(functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")).between(5, 8), 2)
        		.when(functions.month(functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy")).between(9, 12), 3))
		.withColumn("idProcessoSeletivo", functions.col("idProcessoSeletivo").cast("long"))
        .withColumn("nome", functions.col("nome"))
		.withColumn("status", functions.col("status"))
        .withColumn("descricao", functions.col("descricao"))
		.withColumn("criadoPor",functions.col("criadoPor"))
		.withColumn("tempoMedio", functions.col("idProcessoSeletivo").cast("long"))
		.withColumn("date_diff", functions.datediff(functions.to_date(functions.col("datacontratacao"), "dd/MM/yyyy"), functions.to_date(functions.col("datainiciovaga"), "dd/MM/yyyy")))
		.withColumn("idParticipanteRH", functions.col("idParticipanteRH").cast("long"))
		.withColumn("cargo", functions.col("cargo"))
		.withColumn("idVaga", functions.col("idVaga").cast("long"))
		.withColumn("titulovaga", functions.col("titulovaga"))
		.withColumn("numeroposicoes", functions.col("numeroposicoes").cast("integer"))
		.withColumn("requisitosvagas", functions.col("requisitosvagas"))
		.withColumn("estado", functions.col("estado"))
		.withColumn("dataCriacao", functions.to_date(functions.col("dataCriacao"), "dd/MM/yyyy"))
		.withColumn("inicioProcessoSeletivo", functions.to_date(functions.col("inicioProcessoSeletivo"), "dd/MM/yyyy"))
		.withColumn("fimProcessoSeletivo", functions.to_date(functions.col("fimProcessoSeletivo"), "dd/MM/yyyy"))
		.withColumn("idCandidato", functions.col("idCandidato").cast("long"))
		.withColumn("nomeCandidato", functions.col("nomeCandidato"))
		.withColumn("idCriterio", functions.col("idCriterio").cast("long"))
		.withColumn("nomeCriterio", functions.col("nomeCriterio"))
		.withColumn("pontuacao", functions.col("pontuacao").cast("long"));



		var temposDs = serviceTempo.SalvarDatas(dadosPlanilhaTratados);

		service.SalvarProcessosSeletivos(temposDs);

		serviceParticipantesRH.SalvarParticipantesRH(temposDs);

		serviceVagas.SalvarVagas(temposDs);
		
		serviceCriterios.SalvarCriterios(temposDs);
		
		serviceCandidatos.SalvarCandidatos(temposDs);

		serviceContratacoes.SalvarContratacoes(temposDs);
		
		serviceAvaliacoes.SalvarAvaliacoes(temposDs);

   ```
   
* Salvar(): Nesse método são carregados os dados da planilha através de uma instância do Spark e feito o mapeamento das colunas da planilha com os campos das tabelas no banco de dados utilizando os métodos “withColumn”  do framework. Um ponto importante a ressaltar é relativo a salvar os registros das tabelas de fatos do modelo, para isso foi necessário agrupar os registros das tabelas de dimensão e realizar um tratamento para obter as medidas previstas no modelo estrela.

</details>   


 - Contribui com a implementação das rotinas para retornar as métricas de contratações e avaliações dos processos seletivos

 <details open><summary>Detalhes das rotinas para retorno das métricas</summary>
       
   ```java

@Repository
public interface FatoContratacoesRepository extends JpaRepository<FatoContratacoes, Integer>{

	 	@Query(nativeQuery = true, value =  "SELECT a.processo_seletivo, sum(a.tempo_medio) / count(a.processo_seletivo) tempo_medio, b.nome FROM fato_contratacoes a INNER JOIN dim_processo_seletivo b ON b.id_processo_seletivo = a.processo_seletivo WHERE (b.inicio_processo_seletivo < :fim || :fim is null) and (b.fim_processo_seletivo > :inicio or b.fim_processo_seletivo is null)  GROUP BY a.processo_seletivo")
	    List<ProcessoSeletivoTempoMedioDto> RetornarTempoMedioProcessoSeletivo(@Param("inicio") LocalDateTime inicio, @Param("fim") Optional<LocalDateTime> fim);
	
	
	    @Query(nativeQuery = true, value =  "SELECT a.processo_seletivo, b.nome, sum(a.quantidade) quantidade FROM fato_contratacoes a INNER JOIN dim_processo_seletivo b ON b.id_processo_seletivo = a.processo_seletivo WHERE (b.inicio_processo_seletivo < :fim || :fim is null) and (b.fim_processo_seletivo > :inicio or b.fim_processo_seletivo is null) GROUP BY a.processo_seletivo")
	    List<ProcessoSeletivoQuantidadeDto> RetornarQuantidadeProcessoSeletivo(@Param("inicio") LocalDateTime inicio, @Param("fim") Optional<LocalDateTime> fim);

@Query(nativeQuery = true, value = "SELECT v.titulo_vaga, AVG(f.tempo_medio) " +
       "FROM fato_contratacoes f " +
       "JOIN dim_vaga v ON f.vaga = v.id_vaga " +
       "JOIN dim_tempo t ON f.tempo = t.id_tempo " +
       "WHERE (t.ano > :anoInicial OR (t.ano = :anoInicial AND t.mes >= :mesInicial)) " +
       "AND (t.ano < :anoFinal OR (t.ano = :anoFinal AND t.mes <= :mesFinal)) " +
       "GROUP BY v.titulo_vaga")
    List<Object[]> TempoMedioContratacoesPorVaga(
        @Param("mesInicial") int mesInicial,
        @Param("anoInicial") int anoInicial,
        @Param("mesFinal") int mesFinal,
        @Param("anoFinal") int anoFinal);

}
   ```

Nesse trecho da classe de repositório o método "RetornarTempoMedioProcessoSeletivo" é realizado um select para retornar o tempo médio de contratação por processo seletivo, utilizo uma função de soma do tempo médio e faço o agrupamento por processo seletivo e utilizo um filtro de inicio e fim. </br>
O método "RetornarQuantidadeProcessoSeletivo" retorna o total de contratações realizadas por processo seletivo, e também faço um filtro por data inicio e fim.</br>
O método "TempoMedioContratacoesPorVaga" retorna o tempo médio de contratações para cada vaga aberta no processo seletivo, nesse método é passado os parametros de mês e ano inicial e final

</details> 

## Conhecimentos Adquiridos

#### Aprendizado do VueJs:
    Adquiri habilidades no uso do VueJs, explorando suas funcionalidades e sintaxe.
#### Consulta à Documentação Oficial:
    Compreendi a importância de consultar a documentação oficial do VueJs para obter informações detalhadas e precisas sobre a tecnologia.
#### Estudo Aprofundado:
    Reconheci a necessidade de dedicar tempo a um estudo aprofundado para construir uma base sólida e confiável de conhecimento em VueJs.
#### Noções Básicas vs. Complexidades:
    Percebi que, embora os tutoriais sejam úteis para noções básicas, o estudo da documentação permitiu a compreensão das complexidades da tecnologia.
#### Exploração de Recursos Avançados:
    Aprofundei meu conhecimento explorando recursos avançados do VueJs, além do que é geralmente abordado em tutoriais introdutórios.
#### Constante Busca por Novos Aprendizados:
    Reforcei a importância de estar constantemente em busca de novos aprendizados para acompanhar as evoluções tecnológicas.
#### Atualização sobre Tendências do Mercado:
    Compreendi a necessidade de manter-me atualizado sobre as últimas tecnologias e tendências do mercado para permanecer relevante no cenário profissional.
#### Desenvolvimento de Projeto Sofisticado:
    Utilizando o conhecimento adquirido, desenvolvi um projeto mais sofisticado e eficaz, incorporando práticas avançadas do VueJs.
#### Aquisição de Habilidades Valiosas:
    Ao explorar a documentação e desenvolver um projeto mais complexo, adquiri habilidades valiosas que contribuíram significativamente para minha trajetória profissional.

<br>

<details close></summary></summary>

Clique [aqui](https://github.com/Doc-Docker/APISubiter) para mais detalhes do projeto.

</details>

<br>

</details>
