package com.algaworks.algafood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;

import lombok.var;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.algaworks.algafood.infrastructure.repository.RestauranteRepositoryQueries
	 * #find(java.lang.String, java.math.BigDecimal, java.math.BigDecimal)
	 */
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);

		Root<Restaurante> root = criteria.from(Restaurante.class);

		var predicates = new ArrayList<Predicate>();

		if (StringUtils.hasLength(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}

		if (taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}

		if (taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}

		if (predicates.size() > 0) {
			criteria.where(predicates.toArray(new Predicate[0]));
		}

		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		return query.getResultList();

		/*
		 * var jpql = new StringBuilder(); var parametros = new HashMap<String,
		 * Object>();
		 * 
		 * jpql.append("from Restaurante where 0 = 0 ") ;
		 * 
		 * if (StringUtils.hasLength(nome)) { jpql.append("and nome like :nome ");
		 * parametros.put("nome", "%" + nome + "%"); }
		 * 
		 * if (taxaFreteInicial != null) {
		 * jpql.append("and taxaFrete >= :taxaFreteInicial ");
		 * parametros.put("taxaFreteInicial", taxaFreteInicial); }
		 * 
		 * if (taxaFreteInicial != null) {
		 * jpql.append("and taxaFrete >= :taxaFreteInicial ");
		 * parametros.put("taxaFreteInicial", taxaFreteInicial); }
		 * 
		 * if (taxaFreteFinal != null) {
		 * jpql.append("and taxaFrete <= :taxaFreteFinal ");
		 * parametros.put("taxaFreteFinal", taxaFreteFinal); }
		 * 
		 * TypedQuery<Restaurante> query = manager .createQuery(jpql.toString(),
		 * Restaurante.class);
		 * 
		 * parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
		 * return query.getResultList();
		 */

	}

}
