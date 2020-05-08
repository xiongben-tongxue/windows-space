package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

/**
 * <p>Title:ZSMART </p>
 *
 * <p>Description: SfaLeadSourceDAO </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:ztesoft </p>
 *
 * <p>Created Date:2012-7-2 18:47:51 </p>
 *
 * @author: ren.zhen
 * @version R11
 */

import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadSourceDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadSourceDto;
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
public class SfaLeadSourceDAOMysql extends BaseDAO implements ISfaLeadSourceDAO {
    
    /**
     * 构造函数
     */
    public SfaLeadSourceDAOMysql() {
    }

    /**
     * 
     * Description: 增加<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadSourceDto
     * @return SfaLeadSourceDto
     * @throws BaseAppException <br>
     */
    public SfaLeadSourceDto insertSfaLeadSource(SfaLeadSourceDto dto) throws BaseAppException {
        String sqlStr = "INSERT INTO \r\n" + " SFA_LEAD_SOURCE(SOURCE_ID,SOURCE_NAME,COMMENTS,SP_ID) \r\n"
            + " VALUES(?,?,?,?)";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getSourceId());
        pa.set("", dto.getSourceName());
        pa.set("", dto.getComments());
        pa.set("", dto.getSpId());

        executeUpdate(sqlStr, pa);
        return dto;
    }

    /**
     * 
     * Description: 修改<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadSourceDto
     * @return int
     * @throws BaseAppException <br>
     */
    public int updateSfaLeadSource(SfaLeadSourceDto dto) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_SOURCE\r\n" + " SET   SOURCE_NAME=?,COMMENTS=?,SP_ID=? \r\n"
            + " WHERE SOURCE_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getSourceName());
        pa.set("", dto.getComments());
        pa.set("", dto.getSpId());
        pa.set("", dto.getSourceId());

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: 删除<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param sourceId Long
     * @return int
     * @throws BaseAppException <br>
     */
    public int deleteSfaLeadSource(Long sourceId) throws BaseAppException {
        String sqlStr = "DELETE SFA_LEAD_SOURCE\r\n" + " WHERE SOURCE_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", sourceId);

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: 查询<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param sourceId Long
     * @return SfaLeadSourceDto
     * @throws BaseAppException <br>
     */
    public SfaLeadSourceDto selectSfaLeadSource(Long sourceId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " SOURCE_ID,SOURCE_NAME,COMMENTS,SP_ID \r\n" + " FROM  SFA_LEAD_SOURCE \r\n"
            + " WHERE SOURCE_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", sourceId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadSourceDto>() {
            public SfaLeadSourceDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadSourceDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadSourceDto();
                    dto.setSourceId(op.getLong(rs, dbloop++));
                    dto.setSourceName(op.getString(rs, dbloop++));
                    dto.setComments(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                }
                return dto;
            }
        });
    }

    /**
     * 
     * Description: 根据名称查询<br> 
     *  
     * @author <br>
     * @param sourceName String
     * @param spId String <br>
     * @return SfaLeadSourceDto
     * @throws BaseAppException <br>
     */
    public SfaLeadSourceDto selectSfaLeadSourceByName(String sourceName, Long spId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " SOURCE_ID,SOURCE_NAME,COMMENTS,SP_ID \r\n" + " FROM  SFA_LEAD_SOURCE \r\n"
            + " WHERE SOURCE_NAME=? AND SP_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("SOURCE_NAME", sourceName);
        pa.set("SP_ID", spId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadSourceDto>() {
            public SfaLeadSourceDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadSourceDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadSourceDto();
                    dto.setSourceId(op.getLong(rs, dbloop++));
                    dto.setSourceName(op.getString(rs, dbloop++));
                    dto.setComments(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                }
                return dto;
            }
        });
    }

}
