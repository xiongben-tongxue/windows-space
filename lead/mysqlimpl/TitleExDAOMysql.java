package com.ztesoft.zsmart.bss.sfa.lead.dao.mysqlimpl;

import com.ztesoft.zsmart.bss.common.utils.BusiBaseDAO;
import com.ztesoft.zsmart.bss.sfa.lead.dao.ITitleExDAO;
import com.ztesoft.zsmart.bss.sfa.lead.model.TitleDto;
import com.ztesoft.zsmart.core.exception.BaseAppException;

/**
 * 
 * <Description> <br> 
 *  
 * @author <br>
 * @version V8<br>
 * @taskId <br>
 * @CreateDate 2012-9-3 <br>
 * @since V8<br>
 * @see com.ztesoft.zsmart.bss.sfa.contact.dao.abstractimpl <br>
 */
public class TitleExDAOMysql extends BusiBaseDAO implements ITitleExDAO {
    /**
     * 构造函数
     */
    public TitleExDAOMysql() {
    }

    /**
     * 
     * Description: 根据titleName查询<br> 
     *  
     * @author <br>
     * @param titleName String <br>
     * @param spId String <br>
     * @return TitleDto <br>
     * @throws BaseAppException <br>
     */
    public TitleDto selectTitleByName(String titleName, Long spId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " TITLE_ID,TITLE_NAME,SP_ID \r\n" + " FROM SFA_TITLE \r\n"
            + " WHERE TITLE_NAME = ? AND SP_ID = ?";

        return this.selectObject(sqlStr, TitleDto.class, titleName, spId);

    }
    
    /**
     * Description: 查询 <br> 
     *  
     * @author song.chenghao<br>
     * @taskId <br>
     * @param titleId <br>
     * @return <br>
     * @throws BaseAppException <br>
     */ 
    public TitleDto selectTitle(Long titleId) throws BaseAppException {
        String sqlStr = "SELECT \r\n" + " TITLE_ID,TITLE_NAME,SP_ID \r\n" + " FROM SFA_TITLE \r\n"
            + " WHERE TITLE_ID = ?";

        return this.selectObject(sqlStr, TitleDto.class, titleId);

    }
}
