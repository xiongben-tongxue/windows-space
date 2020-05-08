package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

/**
 * <p>Title:ZSMART</p>
 * <p>Description: SfaLeadTypeDAO</p>
 * <p>Company: ztesoft</p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Created Date: 2013-1-26</p>
 *
 * @author ren.zhen <br/>
 * @version 1.1 <br/>
 */

import com.ztesoft.zsmart.bss.common.utils.BusiBaseDAO;
import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadTypeDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadTypeDto;
import com.ztesoft.zsmart.core.exception.BaseAppException;

/**
 * <Description> <br/>
 * 
 * @author ren.zhen <br/>
 * @version 1.1 <br/>
 * @CreateDate 2013-1-26 <br/>
 * @since 8.0 <br/>
 * @taskId <br/>
 */
public class SfaLeadTypeDAOMysql extends BusiBaseDAO implements ISfaLeadTypeDAO {

    /**
     * 构造函数
     */
    public SfaLeadTypeDAOMysql() {
    }

    /**
     * Description:
     * 
     * @param sfaLeadTypeDto <br/>
     * @return int <br/>
     * @throws BaseAppException <br/>
     */
    public int insertSfaLeadType(SfaLeadTypeDto sfaLeadTypeDto) throws BaseAppException {
        String sqlStr = "INSERT INTO SFA_LEAD_TYPE(LEAD_TYPE,LEAD_TYPE_NAME,COMMENTS,SP_ID)"
            + " VALUES(:LEAD_TYPE,:LEAD_TYPE_NAME,:COMMENTS,:SP_ID)";
        return this.updateObject(sqlStr, sfaLeadTypeDto);
    }

    /**
     * Description:
     * 
     * @param sfaLeadTypeDto <br/>
     * @return int <br/>
     * @throws BaseAppException <br/>
     */
    public int updateSfaLeadType(SfaLeadTypeDto sfaLeadTypeDto) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_TYPE SET LEAD_TYPE_NAME=:LEAD_TYPE_NAME,COMMENTS=:COMMENTS,SP_ID=:SP_ID"
            + " WHERE LEAD_TYPE=:LEAD_TYPE";
        return this.updateObject(sqlStr, sfaLeadTypeDto);
    }

    /**
     * Description:
     * 
     * @param leadType <br/>
     * @return int <br/>
     * @throws BaseAppException <br/>
     */
    public int deleteSfaLeadType(Long leadType) throws BaseAppException {
        String sqlStr = "DELETE FROM SFA_LEAD_TYPE" + " WHERE LEAD_TYPE=?";
        return this.updateObject(sqlStr, leadType);
    }

    /**
     * Description:
     * 
     * @param leadType <br/>
     * @return SfaLeadTypeDto <br/>
     * @throws BaseAppException <br/>
     */
    public SfaLeadTypeDto selectSfaLeadType(Long leadType) throws BaseAppException {
        String sqlStr = "SELECT LEAD_TYPE,LEAD_TYPE_NAME,COMMENTS,SP_ID FROM SFA_LEAD_TYPE" + " WHERE LEAD_TYPE=?";
        return this.selectObject(sqlStr, SfaLeadTypeDto.class, leadType);
    }
    /**
     * Description:
     * 
     * @param leadTypeName <br/>
     * @param spId String <br>
     * @return SfaLeadTypeDto <br/>
     * @throws BaseAppException <br/>
     */
    public SfaLeadTypeDto selectSfaLeadTypeByName(String leadTypeName, Long spId) throws BaseAppException {
        String sqlStr = "SELECT LEAD_TYPE,LEAD_TYPE_NAME,COMMENTS,SP_ID FROM SFA_LEAD_TYPE" +
                " WHERE LEAD_TYPE_NAME= ? AND SP_ID = ? ";

        return this.selectObject(sqlStr, SfaLeadTypeDto.class, leadTypeName, spId);
    }

}
