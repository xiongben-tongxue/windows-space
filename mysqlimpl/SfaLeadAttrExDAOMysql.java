package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

import com.ztesoft.zsmart.bss.common.utils.BusiBaseDAO;
import com.ztesoft.zsmart.bss.sfa.coreapi.common.JdbcUtil4SFA;
import com.ztesoft.zsmart.bss.sfa.lead.dao.ISfaLeadAttrExDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadAttrDto;
import com.ztesoft.zsmart.bss.sfa.lead.model.SfaLeadAttrExDto;
import com.ztesoft.zsmart.core.exception.BaseAppException;
import com.ztesoft.zsmart.core.jdbc.JdbcTemplate;
import com.ztesoft.zsmart.core.jdbc.ParamArray;
import com.ztesoft.zsmart.core.jdbc.ParamMap;
import com.ztesoft.zsmart.core.jdbc.ParamObject;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Title: ZSMART
 * </p>
 * <p>
 * Description: GmGoodsModelAttrExDAO.java
 * </p>
 * <p>
 * Copyright: Copyright (c) 2011
 * </p>
 * <p>
 * Company: ztesoft
 * </p>
 * <p>
 * Created Date: 2012-4-25
 * </p>
 * 
 * @author: zhang.jing
 * @version: R13 @Task： @Reason：
 */
public class SfaLeadAttrExDAOMysql extends BusiBaseDAO implements ISfaLeadAttrExDAO {

    /**
     * 构造函数
     */
    public SfaLeadAttrExDAOMysql() {
    }

    /**
     * Description:根据条件查询货品细类 <br>
     * 
     * @author <br>
     * @taskId <br>
     * @param reqDto SfaLeadAttrDto
     * @return List<SfaLeadAttrExDto>
     * @throws BaseAppException <br>
     */
    public List<SfaLeadAttrExDto> qrySfaLeadAttr(SfaLeadAttrDto reqDto) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " A.ATTR_ID,A.DEFAULT_VALUE,A.SP_ID,A.SEQ,B.INPUT_TYPE,C.ATTR_NAME \r\n"
            + " FROM  SFA_LEAD_ATTR A,BASE_ATTR B,ATTR C \r\n" + " WHERE A.ATTR_ID = B.BASE_ATTR_ID \r\n"
            + "  AND B.BASE_ATTR_ID = C.ATTR_ID \r\n" + " [ AND NVL(A.SP_ID,0) = :SP_ID]";

        ParamMap pm = new ParamMap();

        if (reqDto != null && null != reqDto.getSpId()) {
            pm.set("SP_ID", reqDto.getSpId());
        }

        List<Object> list = this.queryListToSimpObj(sqlStr, pm, SfaLeadAttrExDto.class);
        List<SfaLeadAttrExDto> dtoList = new ArrayList<SfaLeadAttrExDto>(list.size());
        for (Object dto : list) {
            dtoList.add((SfaLeadAttrExDto) dto);
        }
        return dtoList;
    }

    /**
     * Description: <br>
     * 
     * @author <br>
     * @taskId <br>
     * @return int
     * @throws BaseAppException <br>
     */
    public int delSfaLeadAttr(Long spId) throws BaseAppException {
        String sqlStr = "DELETE FROM SFA_LEAD_ATTR\r\n" + " WHERE 1=1 AND SP_ID = ?";
        ParamArray pa = new ParamArray();
        pa.set("", spId);
        return executeUpdate(sqlStr, pa);
    }

    /**
     * Description: <br>
     * 
     * @author <br>
     * @taskId <br>
     * @param dtoArr SfaLeadAttrExDto[]
     * @throws BaseAppException <br>
     */
    public void addSfaLeadAttrBatch(SfaLeadAttrExDto[] dtoArr) throws BaseAppException {
        String sqlStr = "INSERT INTO \r\n" + " SFA_LEAD_ATTR(ATTR_ID,DEFAULT_VALUE,SP_ID,SEQ) \r\n"
            + " VALUES(:ATTR_ID,:DEFAULT_VALUE,:SP_ID,:SEQ)";

        ParamObject[] paraList = ParamObject.newParamObjectList(4, dtoArr.length);
        int i = 0;
        for (int size = dtoArr.length; i < size; i++) {
            paraList[0].setBatchElement("ATTR_ID", dtoArr[i].getAttrId(), i);
            paraList[1].setBatchElement("DEFAULT_VALUE", dtoArr[i].getDefaultValue(), i);
            paraList[2].setBatchElement("SP_ID", dtoArr[i].getSpId(), i);
            paraList[3].setBatchElement("SEQ", dtoArr[i].getSeq(), i);

        }
        JdbcTemplate.executeBatch(JdbcUtil4SFA.getDbIdentifier(), sqlStr, ParamMap.wrap(paraList));
    }
}
