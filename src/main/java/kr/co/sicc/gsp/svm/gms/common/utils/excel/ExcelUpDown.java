package kr.co.sicc.gsp.svm.gms.common.utils.excel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.sicc.gsp.svm.gms.common.login.UserInfo;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.gmsutil.excel.ExcelHelper;
import com.gmsutil.excel.ExcelReader;
import com.gmsutil.excel.ExcelService;
import com.gmsutil.excel.ExcelVO;
import com.gmsutil.excel.ExcelWriter;
import com.gmsutil.file.FilePath;
import kr.co.sicc.gsp.svm.sicc.exception.SiccException;

/**
 * <pre>
 * com.gms.common.utils.excel
 * ExcelUpDown.java
 * Description :
 *		엑셀의 업로드와 다운로드를 실행한다.
 * History     :
 * </pre>
 *
 * @author	 : randy80
 * @Date	 : 2016. 4. 29.
 * @Version : 1.0
 *
 */
public class ExcelUpDown<T extends ExcelHelper> {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    private ExcelVO excelVo = new ExcelVO();
	private int totalCnt = 0;
	private int successCnt = 0;
	private int failCnt = 0;

	/**
	 * @param filePath
	 * @param service
	 * @param helperClass
	 * @param cpCd
	 * @param user
	 */
	public ExcelUpDown(FilePath filePath, ExcelService service, Class<T> helperClass, String cpCd, UserInfo user, Map<String, Object> params) {
	    excelVo.setFilePath(filePath);
	    excelVo.setService(service);
	    /*excelVo.setHelperClass(helperClass);
	    excelVo.setUser(user);
	    excelVo.setParams(params);*/
	}

	/**
	 * @param filePath
	 * @param service
	 * @param helperClass
	 */
	public ExcelUpDown(FilePath returnFilePath, ExcelService service, Class<T> helperClass, Map<String, Object> params) {
	    excelVo.setReturnFilePath(returnFilePath);
        excelVo.setService(service);
        /*excelVo.setHelperClass(helperClass);
        excelVo.setParams(params);*/
	}

	public ExcelUpDown(ExcelVO excelVo) {
        this.excelVo = excelVo;
    }

	/**
	 * 엑셀의 업로드를 진행한다.
	 *
	 * @Version : 1.0
	 * @Method upload
	 * @param returnFilePath
	 * @throws EncryptedDocumentException
	 * @throws InvalidFormatException
	 * @throws FileNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public Map<String, Integer> upload(FilePath returnFilePath) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, InstantiationException, IllegalAccessException, IOException {
	    excelVo.setReturnFilePath(returnFilePath);
		return upload();
	}

	public Map<String, Integer> upload() throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, InstantiationException, IllegalAccessException, IOException {
        ExcelReader<T> excelReader = null;//new ExcelReader<>(excelVo);
        ExcelWriter<T> excelWriter = null;//new ExcelWriter<>(excelVo);

        if(excelVo.isMakeHeader()) {
            excelWriter.header(excelReader.getStartColumn());
        } else {
            excelWriter.setWorkbook(excelReader.getWorkbook());
        }

        do {
            try {
                totalCnt++;
                Map<String, Object> map = excelReader.read();
                if (map == null) {
                    if (excelReader.failed() != null) {
                        failCnt++;
                        excelWriter.write(excelReader.failed());
                    }
                    continue;
                } else if(map.isEmpty()) {
                    totalCnt--;
                    continue;
                }

                if (excelVo.isReturnSuccess() && excelReader.successed() != null) {
                    excelWriter.write(excelReader.successed());
                }

                try {
                    /*map.put("cp_cd", excelVo.getUser().getCp_cd());
                    if (!excelVo.getService().excel_dupl_chk(map)) {
                        map.put("crt_id", excelVo.getUser().getUsername());
                        map.put("crt_ip", excelVo.getUser().getUser_ip());
                        map.put("udt_id", excelVo.getUser().getUsername());
                        map.put("udt_ip", excelVo.getUser().getUser_ip());
                        excelVo.getService().excel_insert(map);
                    } else {
                        map.put("udt_id", excelVo.getUser().getUsername());
                        map.put("udt_ip", excelVo.getUser().getUser_ip());
                        excelVo.getService().excel_update(map);
                    }
                    successCnt++;*/
                } catch (SiccException e) {
                    e.printStackTrace();
                    excelReader.makeFailedRow(e.getLocalizedMessage());
                    throw e;
                }
            } catch (SiccException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
                if (excelReader.failed() != null) {
                    failCnt++;
                    excelWriter.write(excelReader.failed());
                }
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (excelReader.next());

        excelReader.close();
        excelWriter.close();

        Map<String, Integer> rtn = new HashMap<>();
        rtn.put("total", totalCnt);
        rtn.put("success", successCnt);
        rtn.put("fail", failCnt);
        return rtn;
    }

	/**
	 * 엑셀의 다운로드를 진행한다.
	 *
	 * @Version : 1.0
	 * @Method down
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void down() throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException {
        try {
            ExcelWriter<T> excelWriter = null;//new ExcelWriter<>(excelVo);
            if(excelVo.getSrcFile().equals("")) {
                excelWriter.header(0);
            } else {
                //excelWriter.setWorkbook(excelWriter.getSrcWorkbook(excelVo.getSrcFile()));
            }

            List<Map<String, Object>> list = excelVo.getService().excel_list(excelVo.getParams());
            for (Map<String, Object> map : list) {
                excelWriter.write(map);
            }

            excelWriter.close();
        } catch (EncryptedDocumentException | InvalidFormatException e) {
        	logger.debug(e.getMessage());
            throw new SiccException(e);
        }
	}
}
