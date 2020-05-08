package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

/**
 * <p>Title:ZSMART </p>
 *
 * <p>Description: SfaLeadAreaDAO </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:ztesoft </p>
 *
 * <p>Created Date:2012-7-2 18:48:18 </p>
 *
 * @author: ren.zhen
 * @version R11
 */

import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadAreaDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadAreaDto;
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
public class SfaLeadAreaDAOMysql extends BaseDAO implements ISfaLeadAreaDAO {
    /**
     * 构造函数
     */
    public SfaLeadAreaDAOMysql() {
    }

    /**
     * 
     * Description:增加 <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadAreaDto
     * @return SfaLeadAreaDto
     * @throws BaseAppException <br>
     */
    public SfaLeadAreaDto insertSfaLeadArea(SfaLeadAreaDto dto) throws BaseAppException {
        String sqlStr = "INSERT INTO \r\n" + " SFA_LEAD_AREA(AREA_ID,AREA_LEVEL,PARENT_AREA_ID,AREA_NAME,SP_ID) \r\n"
            + " VALUES(?,?,?,?,?)";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getAreaId());
        pa.set("", dto.getAreaLevel());
        pa.set("", dto.getParentAreaId());
        pa.set("", dto.getAreaName());
        pa.set("", dto.getSpId());

        executeUpdate(sqlStr, pa);
        return dto;
    }

    /**
     * 
     * Description:修改 <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadAreaDto
     * @return int
     * @throws BaseAppException <br>
     */
    public int updateSfaLeadArea(SfaLeadAreaDto dto) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_AREA\r\n" + " SET   AREA_LEVEL=?,PARENT_AREA_ID=?,AREA_NAME=?,SP_ID=? \r\n"
            + " WHERE AREA_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getAreaLevel());
        pa.set("", dto.getParentAreaId());
        pa.set("", dto.getAreaName());
        pa.set("", dto.getSpId());
        pa.set("", dto.getAreaId());

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: 删除<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param areaId Long
     * @return int
     * @throws BaseAppException <br>
     */
    public int deleteSfaLeadArea(Long areaId) throws BaseAppException {
        String sqlStr = "DELETE SFA_LEAD_AREA\r\n" + " WHERE AREA_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", areaId);

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: 查询<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param areaId Long
     * @return SfaLeadAreaDto
     * @throws BaseAppException <br>
     */
    public SfaLeadAreaDto selectSfaLeadArea(Long areaId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " AREA_ID,AREA_LEVEL,PARENT_AREA_ID,AREA_NAME,SP_ID \r\n"
            + " FROM  SFA_LEAD_AREA \r\n" + " WHERE AREA_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", areaId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadAreaDto>() {
            public SfaLeadAreaDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadAreaDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadAreaDto();
                    dto.setAreaId(op.getLong(rs, dbloop++));
                    dto.setAreaLevel(op.getString(rs, dbloop++));
                    dto.setParentAreaId(op.getLong(rs, dbloop++));
                    dto.setAreaName(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                }
                return dto;
            }
        });
    }

    /**
     * 
     * Description: 查询<br> 
     *  
     * @author <br>
     * @param areaName String
     * @param spId String <br>
     * @return SfaLeadAreaDto
     * @throws BaseAppException <br>
     */
    public SfaLeadAreaDto selectSfaLeadAreaByName(String areaName, Long spId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " AREA_ID,AREA_LEVEL,PARENT_AREA_ID,AREA_NAME,SP_ID \r\n"
            + " FROM  SFA_LEAD_AREA \r\n" + " WHERE AREA_NAME=? AND SP_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("AREA_NAME", areaName);
        pa.set("SP_ID", spId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadAreaDto>() {
            public SfaLeadAreaDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadAreaDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadAreaDto();
                    dto.setAreaId(op.getLong(rs, dbloop++));
                    dto.setAreaLevel(op.getString(rs, dbloop++));
                    dto.setParentAreaId(op.getLong(rs, dbloop++));
                    dto.setAreaName(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                }
                return dto;
            }
        });
    }

}
