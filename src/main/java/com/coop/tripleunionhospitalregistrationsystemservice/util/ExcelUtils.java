package com.coop.tripleunionhospitalregistrationsystemservice.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExcelUtils {
  /**
   * excel导出
   *
   * @param response    http响应对象
   * @param list        导出的list内容数据
   * @param clazz       导出的类型
   * @param fileNamePre 文件名（不含后缀）
   * @param sheetName   sheet名
   * @throws IOException IO异常
   */
  public static void exportExcel(HttpServletResponse response, List list, Class clazz, String fileNamePre, String sheetName) throws Exception {

    // 导出时候会出现中文无法识别问题，需要转码
    String fileName = new String(fileNamePre.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setCharacterEncoding("utf-8");
    response.addHeader("Access-Control-Expose-Headers", "Content-disposition");
    response.setHeader("Content-Type","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ExcelTypeEnum.XLSX.getValue());
    // 调用工具类
    EasyExcel.write(response.getOutputStream(), clazz)
            .sheet(sheetName)
            .doWrite(list);
  }

  public static void writeExcel(String file) throws Exception {
    // 创建 Excel 写入器
    String fileName = file +".xlsx";
    OutputStream outputStream = Files.newOutputStream(Paths.get(fileName));
    ExcelWriter excelWriter = EasyExcel.write(outputStream).build();

    // 写入数据
    WriteSheet writeSheet = EasyExcel.writerSheet(0).build();
    TestData testData = new TestData();
    testData.setContent("hello world");
    List<TestData> dataList = Collections.singletonList(testData);
    excelWriter.write(dataList, writeSheet);
    // 关闭 Excel 写入器
    excelWriter.finish();
  }
  public static class TestData {
    private String content;

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }
  }
}

