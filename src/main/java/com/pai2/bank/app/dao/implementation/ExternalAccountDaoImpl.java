package com.pai2.bank.app.dao.implementation;


import com.pai2.bank.app.dao.ExternalAccountDao;
import com.pai2.bank.app.model.Externalaccount;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Szymon on 14.06.2018.
 */

@Stateless(name = "ExternalAccountDaoImpl", mappedName = "ExternalAccountDaoImpl")
public class ExternalAccountDaoImpl extends DaoImpl<Integer, Externalaccount> implements ExternalAccountDao {

}
