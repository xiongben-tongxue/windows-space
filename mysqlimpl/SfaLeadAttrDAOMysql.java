package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

/**
 * <p>Title:ZSMART </p>
 *
 * <p>Description: SfaLeadAttrDAO </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:ztesoft </p>
 *
 * <p>Created Date:2012-7-2 18:48:07 </p>
 *
 * @author: ren.zhen
 * @version R11
 */

import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadAttrDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadAttrDto;
import com.ztesoft.zsmart.core.exception.BaseAppException;
import com.ztesoft.zsmart.core.jdbc.BaseDAO;
import com.ztesoft.zsmart.core.jdbc.ParamArray;
import com.ztesoft.zsmart.core.jdbc.rowset.RowSetMapper;
import com.ztesoft.zsmart.core.jdbc.rowset.RowSetOperator;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * <Description> <br> 
 *  
 * @author <br>
 * @version V8<br>
 * @taskId <br>
 * @CreateDate 2012-9-4 <br>
 * @since V8<br>
 * @see com.ztesoft.zsmart.bss.sfa.lead.dao.abstractimpl <br>
 */
public class SfaLeadAttrDAOMysql extends BaseDAO implements ISfaLeadAttrDAO {
    /**
     * 构造函数
     */
    public SfaLeadAttrDAOMysql() {
    }

    /**
     * 
     * Description:增加 <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadAttrDto
     * @return SfaLeadAttrDto
     * @throws BaseAppException <br>
     */
    public SfaLeadAttrDto insertSfaLeadAttr(SfaLeadAttrDto dto) throws BaseAppException {
        String sqlStr = "INSERT INTO \r\n" + " SFA_LEAD_ATTR(ATTR_ID,SEQ,SP_ID,DEFAULT_VALUE) \r\n"
            + " VALUES(?,?,?,?)";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getAttrId());
        pa.set("", dto.getSeq());
        pa.set("", dto.getSpId());
        pa.set("", dto.getDefaultValue());

        executeUpdate(sqlStr, pa);
        return dto;
    }

    /**
     * 
     * Description:修改 <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadAttrDto
     * @return int
     * @throws BaseAppException <br>
     */
    public int updateSfaLeadAttr(SfaLeadAttrDto dto) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_ATTR\r\n" + " SET   SEQ=?,SP_ID=?,DEFAULT_VALUE=? \r\n" + " WHERE ATTR_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getSeq());
        pa.set("", dto.getSpId());
        pa.set("", dto.getDefaultValue());
        pa.set("", dto.getAttrId());

        return executeUpdate(sqlStr, pa);
    }

    /**
     *
     * Description:修改 <br>
     *
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadAttrDto
     * @return int
     * @throws BaseAppException <br>
     */
    public int updateSfaLeadAttrDefaultValue(SfaLeadAttrDto dto) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_ATTR\r\n" + " SET DEFAULT_VALUE=? \r\n" + " WHERE ATTR_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", dto.getDefaultValue());
        pa.set("", dto.getAttrId());

        return executeUpdate(sqlStr, pa);
    }

    /**
     *
     * Description:修改 <br>
     *
     * @author <br>
     * @taskId <br>
     * @param attrId
     * @param seq
     * @return int
     * @throws BaseAppException <br>
     */
    public int updateSfaLeadAttrSeq(Long attrId, Long seq) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_ATTR\r\n" + " SET SEQ=? \r\n" + " WHERE ATTR_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", seq);
        pa.set("", attrId);

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description:删除 <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param attrId Long
     * @return int
     * @throws BaseAppException <br>
     */
    public int deleteSfaLeadAttr(Long attrId) throws BaseAppException {
        String sqlStr = "DELETE SFA_LEAD_ATTR\r\n" + " WHERE ATTR_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", attrId);

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: 查询<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param attrId Long
     * @return SfaLeadAttrDto
     * @throws BaseAppException <br>
     */
    public SfaLeadAttrDto selectSfaLeadAttr(Long attrId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " ATTR_ID,SEQ,SP_ID,DEFAULT_VALUE \r\n" + " FROM  SFA_LEAD_ATTR \r\n"
            + " WHERE ATTR_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", attrId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadAttrDto>() {
            public SfaLeadAttrDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadAttrDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadAttrDto();
                    dto.setAttrId(op.getLong(rs, dbloop++));
                    dto.setSeq(op.getLong(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                    dto.setDefaultValue(op.getString(rs, dbloop++));
                }
                return dto;
            }
        });
    }

}
