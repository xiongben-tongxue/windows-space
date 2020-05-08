package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

/**
 * <p>Title:ZSMART </p>
 *
 * <p>Description: SfaLeadRatingDAO </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:ztesoft </p>
 *
 * <p>Created Date:2012-7-2 18:17:22 </p>
 *
 * @author: ren.zhen
 * @version R11
 */

import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadRatingDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadRatingDto;
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
public class SfaLeadRatingDAOMysql extends BaseDAO implements ISfaLeadRatingDAO {
    
    /**
     * 构造函数
     */
    public SfaLeadRatingDAOMysql() {
    }

    /**
     * 
     * Description: 增加<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param dto SfaLeadRatingDto
     * @return SfaLeadRatingDto
     * @throws BaseAppException <br>
     */
    public SfaLeadRatingDto insertSfaLeadRating(SfaLeadRatingDto dto) throws BaseAppException {
        String sqlStr = "INSERT INTO \r\n" + " SFA_LEAD_RATING(LEAD_RATING_ID,LEAD_RATING_NAME,COMMENTS,SP_ID) \r\n"
            + " VALUES(?,?,?,?)";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getLeadRatingId());
        pa.set("", dto.getLeadRatingName());
        pa.set("", dto.getComments());
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
     * @param dto SfaLeadRatingDto
     * @return int
     * @throws BaseAppException <br>
     */
    public int updateSfaLeadRating(SfaLeadRatingDto dto) throws BaseAppException {
        String sqlStr = "UPDATE SFA_LEAD_RATING\r\n" + " SET   LEAD_RATING_NAME=?,COMMENTS=?,SP_ID=? \r\n"
            + " WHERE LEAD_RATING_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", dto.getLeadRatingName());
        pa.set("", dto.getComments());
        pa.set("", dto.getSpId());
        pa.set("", dto.getLeadRatingId());

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: 删除<br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param leadRatingId Long
     * @return int
     * @throws BaseAppException <br>
     */
    public int deleteSfaLeadRating(Long leadRatingId) throws BaseAppException {
        String sqlStr = "DELETE SFA_LEAD_RATING\r\n" + " WHERE LEAD_RATING_ID=?";

        ParamArray pa = new ParamArray();

        pa.set("", leadRatingId);

        return executeUpdate(sqlStr, pa);
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param leadRatingId Long
     * @return SfaLeadRatingDto
     * @throws BaseAppException <br>
     */
    public SfaLeadRatingDto selectSfaLeadRating(Long leadRatingId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " LEAD_RATING_ID,LEAD_RATING_NAME,COMMENTS,SP_ID \r\n"
            + " FROM  SFA_LEAD_RATING \r\n" + " WHERE LEAD_RATING_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", leadRatingId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadRatingDto>() {
            public SfaLeadRatingDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadRatingDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadRatingDto();
                    dto.setLeadRatingId(op.getLong(rs, dbloop++));
                    dto.setLeadRatingName(op.getString(rs, dbloop++));
                    dto.setComments(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                }
                return dto;
            }
        });
    }

    /**
     * 
     * Description:查询 <br> 
     *  
     * @author <br>
     * @param leadRatingName String
     * @param spId String <br>
     * @return SfaLeadRatingDto
     * @throws BaseAppException <br>
     */
    public SfaLeadRatingDto selectSfaLeadRating(String leadRatingName, Long spId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " LEAD_RATING_ID,LEAD_RATING_NAME,COMMENTS,SP_ID \r\n"
            + " FROM  SFA_LEAD_RATING \r\n" + " WHERE LEAD_RATING_NAME=? AND SP_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("SFA_LEAD_RATING", leadRatingName);
        pa.set("SP_ID", spId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadRatingDto>() {
            public SfaLeadRatingDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                SfaLeadRatingDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadRatingDto();
                    dto.setLeadRatingId(op.getLong(rs, dbloop++));
                    dto.setLeadRatingName(op.getString(rs, dbloop++));
                    dto.setComments(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                }
                return dto;
            }
        });
    }

}
