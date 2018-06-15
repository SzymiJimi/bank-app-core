package com.pai2.bank.app.dao.implementation;

import com.pai2.bank.app.dao.InvestmentofferDAO;
import com.pai2.bank.app.model.Investmentoffer;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "InvestmentofferDaoImpl", mappedName = "InvestmentofferDaoImpl")
public class InvestmentofferDaoImpl extends DaoImpl<Integer, Investmentoffer> implements InvestmentofferDAO {

    @Override
    public List<Investmentoffer> findInvestmentofferByStateOfOffer(String stateOfOffer) {
        try{
            Query query = getEntityManager().createNamedQuery("Investmentoffer.findByStateOfOffer", Investmentoffer.class);
            query.setParameter("stateOfOffer", stateOfOffer);
            return (List <Investmentoffer>) query.getResultList();
        }catch (Exception ex){
            return null;
        }
    }
}
