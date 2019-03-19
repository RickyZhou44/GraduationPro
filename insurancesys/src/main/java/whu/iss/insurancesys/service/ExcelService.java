package whu.iss.insurancesys.service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/12 0012.
 */
public interface ExcelService {
    boolean exportExcel(String fileName, Integer pageNum, Integer pageSize);
    boolean importExcel(String name);
}
