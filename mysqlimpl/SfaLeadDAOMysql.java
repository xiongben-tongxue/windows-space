package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

/**
 * <p>Title:ZSMART </p>
 *
 * <p>Description: SfaLeadDAO </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:ztesoft </p>
 *
 * <p>Created Date:2012-7-18 10:32:21 </p>
 *
 * @author: li.jianxue
 * @version R11
 */

import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadDto;
import com.ztesoft.zsmart.core.exception.BaseAppException;
import com.ztesoft.zsmart.core.jdbc.BaseDAO;
import com.ztesoft.zsmart.core.jdbc.ParamArray;
import com.ztesoft.zsmart.core.jdbc.rowset.RowSetMapper;
import com.ztesoft.zsmart.core.jdbc.rowset.RowSetOperator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
public class SfaLeadDAOMysql extends BaseDAO implements ISfaLeadDAO {
    /**
     * 构造函数
     */
    public SfaLeadDAOMysql() {
    }

    /**
     * 
     * Description:查询 <br> 
     *  
     * @author <br>
     * @taskId <br>
     * @param leadId Long
     * @return SfaLeadDto
     * @throws BaseAppException <br>
     */
    public SfaLeadDto selectSfaLead(Long leadId) throws BaseAppException {
        String sqlStr = "SELECT \r\n"
            + " LEAD_ID,LEAD_STATE,LEAD_RATING_ID,CMP_ID,SOURCE_ID,TITLE_ID,SEX,AREA_ID,INDUSTRY_ID,CV_CUST_ID,CV_CONTACT_MAN_ID,"
            + "DISPATCH_ORDER_ID,CV_OPP_ID,FIRST_NAME,LAST_NAME,LEAD_NAME,ADDRESS,CUST_NAME,ZIP_CODE,PHONE,FAX,EMAIL,WEB_SITE,FACEBOOK,TWITTER,"
            + "INSTAGRAM,PARTY_TYPE,PARTY_CODE,CREATED_PARTY_TYPE,CREATED_PARTY_CODE,CREATED_DATE,CLOSE_STAFF_ID,CLOSE_DATE,COMMENTS,SP_ID,"
            + "LEAD_TYPE \r\n"
            + " FROM  SFA_LEAD \r\n" + " WHERE LEAD_ID=?";

        ParamArray pa = new ParamArray();
        pa.set("", leadId);

        return query(sqlStr, pa, null, new RowSetMapper<SfaLeadDto>() {
            public SfaLeadDto mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para) throws SQLException,
                BaseAppException {
                SfaLeadDto dto = null;
                if (rs.next()) {
                    int dbloop = 1;
                    dto = new SfaLeadDto();
                    dto.setLeadId(op.getLong(rs, dbloop++));
                    dto.setLeadState(op.getString(rs, dbloop++));
                    dto.setLeadRatingId(op.getLong(rs, dbloop++));
                    dto.setCmpId(op.getLong(rs, dbloop++));
                    dto.setSourceId(op.getLong(rs, dbloop++));
                    dto.setTitleId(op.getLong(rs, dbloop++));
                    dto.setSex(op.getString(rs, dbloop++));
                    dto.setAreaId(op.getLong(rs, dbloop++));
                    dto.setIndustryId(op.getLong(rs, dbloop++));
                    dto.setCvCustId(op.getLong(rs, dbloop++));
                    dto.setCvContactManId(op.getLong(rs, dbloop++));
                    dto.setDispatchOrderId(op.getLong(rs, dbloop++));
                    dto.setCvOppId(op.getLong(rs, dbloop++));
                    dto.setFirstName(op.getString(rs, dbloop++));
                    dto.setLastName(op.getString(rs, dbloop++));
                    dto.setLeadName(op.getString(rs, dbloop++));
                    dto.setAddress(op.getString(rs, dbloop++));
                    dto.setCustName(op.getString(rs, dbloop++));
                    dto.setZipCode(op.getString(rs, dbloop++));
                    dto.setPhone(op.getString(rs, dbloop++));
                    dto.setFax(op.getString(rs, dbloop++));
                    dto.setEmail(op.getString(rs, dbloop++));
                    dto.setWebSite(op.getString(rs, dbloop++));
                    dto.setFacebook(op.getString(rs, dbloop++));
                    dto.setTwitter(op.getString(rs, dbloop++));
                    dto.setInstagram(op.getString(rs, dbloop++));
                    dto.setPartyType(op.getString(rs, dbloop++));
                    dto.setPartyCode(op.getString(rs, dbloop++));
                    dto.setCreatedPartyType(op.getString(rs, dbloop++));
                    dto.setCreatedPartyCode(op.getString(rs, dbloop++));
                    dto.setCreatedDate(op.getDate(rs, dbloop++));
                    dto.setCloseStaffId(op.getLong(rs, dbloop++));
                    dto.setCloseDate(op.getDate(rs, dbloop++));
                    dto.setComments(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                    dto.setLeadType(op.getLong(rs, dbloop++));
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
     * @taskId <br>
     * @param leadName String
     * @return List<SfaLeadDto>
     * @throws BaseAppException <br>
     */
    public List<SfaLeadDto> selectSfaLead(String leadName) throws BaseAppException {
        String sqlStr = "SELECT \r\n "
            + "LD.LEAD_ID,LD.LEAD_STATE,LD.LEAD_RATING_ID,LD.SOURCE_ID,LD.TITLE_ID,LD.LEAD_TYPE,LD.SEX,LD.AREA_ID,LD.INDUSTRY_ID,"
            + "LD.CV_CUST_ID,LD.CV_CONTACT_MAN_ID,LD.DISPATCH_ORDER_ID,LD.CV_OPP_ID,LD.FIRST_NAME,LD.LAST_NAME,"
            + "LD.LEAD_NAME,LD.ADDRESS,LD.CUST_NAME,LD.ZIP_CODE,LD.PHONE,LD.FAX,LD.EMAIL,LD.WEB_SITE,LD.PARTY_TYPE,"
            + "LD.PARTY_CODE,LD.CREATED_PARTY_TYPE,LD.CREATED_PARTY_CODE,LD.CREATED_DATE,LD.CLOSE_STAFF_ID,LD.CLOSE_DATE,"
            + "LD.COMMENTS,LD.SP_ID,LDST.LEAD_STATE_NAME,LDSO.SOURCE_NAME,LDA.AREA_NAME,LDR.LEAD_RATING_NAME,LDT.TITLE_NAME,LDTY.LEAD_TYPE_NAME,"
            + "LDI.INDUSTRY_NAME,FOR_COMM_QUERY.GET_PARTY_CODE_NAME(LD.CREATED_PARTY_TYPE,LD.CREATED_PARTY_CODE) CREATOR_NAME,"
            + "CASE "
            + "WHEN LD.PARTY_TYPE = 'F' THEN (SELECT S.STAFF_NAME FROM BFM_STAFF S WHERE LD.PARTY_CODE = S.STAFF_ID) "
            + "WHEN LD.PARTY_TYPE = 'O' THEN (SELECT O.ORG_NAME FROM BFM_ORG O WHERE LD.PARTY_CODE = O.ORG_ID) "
            + "ELSE '' END AS OWNER_NAME "

            + "FROM SFA_LEAD LD," + "SFA_LEAD_STATE  LDST," + "SFA_LEAD_SOURCE LDSO," + "SFA_LEAD_AREA LDA," + "SFA_LEAD_TYPE LDTY,"
            + "SFA_LEAD_RATING LDR," + "SFA_TITLE  LDT," + "SFA_INDUSTRY LDI " + "WHERE LD.LEAD_STATE = LDST.LEAD_STATE(+) "
            + "AND LD.SOURCE_ID = LDSO.SOURCE_ID(+) " + "AND LD.AREA_ID = LDA.AREA_ID(+) "
            + "AND LD.LEAD_TYPE = LDTY.LEAD_TYPE(+) "
            + "AND LD.LEAD_RATING_ID = LDR.LEAD_RATING_ID(+) " + "AND LD.TITLE_ID = LDT.TITLE_ID(+) "
            + "AND LD.INDUSTRY_ID = LDI.INDUSTRY_ID(+) " + "AND LD.LEAD_STATE = 'P' AND LD.LEAD_NAME like'%'||?||'%'";

        ParamArray pa = new ParamArray();
        pa.set("", leadName);

        return query(sqlStr, pa, null, new RowSetMapper<List<SfaLeadDto>>() {
            public List<SfaLeadDto> mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                List<SfaLeadDto> result = new ArrayList<SfaLeadDto>();
                while (rs.next()) {
                    int dbloop = 1;
                    SfaLeadDto dto = new SfaLeadDto();
                    dto.setLeadId(op.getLong(rs, dbloop++));
                    dto.setLeadState(op.getString(rs, dbloop++));
                    dto.setLeadRatingId(op.getLong(rs, dbloop++));
                    dto.setSourceId(op.getLong(rs, dbloop++));
                    dto.setTitleId(op.getLong(rs, dbloop++));
                    dto.setLeadType(op.getLong(rs, dbloop++));
                    dto.setSex(op.getString(rs, dbloop++));
                    dto.setAreaId(op.getLong(rs, dbloop++));
                    dto.setIndustryId(op.getLong(rs, dbloop++));

                    dto.setCvCustId(op.getLong(rs, dbloop++));
                    dto.setCvContactManId(op.getLong(rs, dbloop++));
                    dto.setDispatchOrderId(op.getLong(rs, dbloop++));
                    dto.setCvOppId(op.getLong(rs, dbloop++));
                    dto.setFirstName(op.getString(rs, dbloop++));
                    dto.setLastName(op.getString(rs, dbloop++));

                    dto.setLeadName(op.getString(rs, dbloop++));
                    dto.setAddress(op.getString(rs, dbloop++));
                    dto.setCustName(op.getString(rs, dbloop++));
                    dto.setZipCode(op.getString(rs, dbloop++));
                    dto.setPhone(op.getString(rs, dbloop++));
                    dto.setFax(op.getString(rs, dbloop++));
                    dto.setEmail(op.getString(rs, dbloop++));
                    dto.setWebSite(op.getString(rs, dbloop++));
                    dto.setPartyType(op.getString(rs, dbloop++));

                    dto.setPartyCode(op.getString(rs, dbloop++));
                    dto.setCreatedPartyType(op.getString(rs, dbloop++));
                    dto.setCreatedPartyCode(op.getString(rs, dbloop++));
                    dto.setCreatedDate(op.getDate(rs, dbloop++));
                    dto.setCloseStaffId(op.getLong(rs, dbloop++));
                    dto.setCloseDate(op.getDate(rs, dbloop++));

                    dto.setComments(op.getString(rs, dbloop++));
                    dto.setSpId(op.getLong(rs, dbloop++));
                    dto.setLeadStateName(op.getString(rs, dbloop++));
                    dto.setSourceName(op.getString(rs, dbloop++));
                    dto.setAreaName(op.getString(rs, dbloop++));
                    dto.setLeadRatingName(op.getString(rs, dbloop++));
                    dto.setTitleName(op.getString(rs, dbloop++));
                    dto.setLeadTypeName(op.getString(rs, dbloop++));
                    dto.setIndustryName(op.getString(rs, dbloop++));
                    dto.setCreatorName(op.getString(rs, dbloop++));
                    dto.setOwnerName(op.getString(rs, dbloop++));
                    result.add(dto);
                }
                return result;
            }
        });
    }

    /**
     * Description:查询线索创建者 <br>
     * 
     * @author wu.songkai<br>
     * @taskId <br>
     * @param dispatchOrderId Long 
     * @return <br>
     * @throws BaseAppException <br>
     */ 
    public List<SfaLeadDto> qrySfaLeadCreator(Long dispatchOrderId) throws BaseAppException {
        StringBuffer sqlStr = new StringBuffer();
        sqlStr.append("SELECT C.STAFF_ID AS PARTY_CODE FROM SFA_LEAD A, BFM_STAFF_JOB B, BFM_STAFF_ORG C ");
        sqlStr.append("WHERE A.CREATED_PARTY_CODE = B.STAFF_JOB_ID AND B.STAFF_ORG_ID = C.STAFF_ORG_ID");
        sqlStr.append(" AND A.DISPATCH_ORDER_ID = ? AND A.CREATED_PARTY_TYPE = 'A' ");

        ParamArray pa = new ParamArray();
        pa.set("", dispatchOrderId);

        return query(sqlStr.toString(), pa, null, new RowSetMapper<List<SfaLeadDto>>() {
            public List<SfaLeadDto> mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                List<SfaLeadDto> result = new ArrayList<SfaLeadDto>();
                while (rs.next()) {
                    int dbloop = 1;
                    SfaLeadDto dto = new SfaLeadDto();
                    dto.setPartyType("F");
                    dto.setPartyCode(op.getString(rs, dbloop++));
                    result.add(dto);
                }
                return result;
            }
        });
    }

    /**
     * Description: 查询线索所有者 <br>
     * 
     * @author wu.songkai<br>
     * @taskId <br>
     * @param dispatchOrderId  Long
     * @return <br>
     * @throws BaseAppException <br>
     */ 
    public List<SfaLeadDto> qrySfaLeadOwner(Long dispatchOrderId) throws BaseAppException {
        StringBuffer sqlStr = new StringBuffer();
        sqlStr.append("SELECT A.PARTY_TYPE,A.PARTY_CODE ");
        sqlStr.append("FROM SFA_LEAD A WHERE A.DISPATCH_ORDER_ID = ? ");

        ParamArray pa = new ParamArray();
        pa.set("", dispatchOrderId);

        return query(sqlStr.toString(), pa, null, new RowSetMapper<List<SfaLeadDto>>() {
            public List<SfaLeadDto> mapRows(RowSetOperator op, ResultSet rs, int colNum, Object para)
                throws SQLException, BaseAppException {
                List<SfaLeadDto> result = new ArrayList<SfaLeadDto>();
                while (rs.next()) {
                    int dbloop = 1;
                    SfaLeadDto dto = new SfaLeadDto();
                    dto.setPartyType(op.getString(rs, dbloop++));
                    dto.setPartyCode(op.getString(rs, dbloop++));
                    result.add(dto);
                }
                return result;
            }
        });
    }

}
