package com.coop.tripleunionhospitalregistrationsystemservice.entity.manager;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadFontStyle;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ContentRowHeight(20) // 内容单元格高度
@HeadRowHeight(25) // 标题单元格高度
@HeadFontStyle(fontName = "宋体", fontHeightInPoints = 10)
public class ExcelObject {

  @ExcelIgnore //忽略导出的字段
  @ApiModelProperty(value = "numberSourceDetailId")
  private int numberSourceDetailId;

  @ExcelIgnore //忽略导出的字段
  @ApiModelProperty(value = "numberSourceId")
  private int numberSourceId;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "科室名",index = 1) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "科室名")
  private String departmentName;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "诊室类型",index = 3) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "诊室类型")
  private String consultingRoomType;

  @ExcelIgnore //忽略导出的字段
  @ApiModelProperty(value = "doctorId")
  private String doctorId;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "医生",index = 0) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "医生")
  private String doctorName;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "医生等级",index = 2) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "医生等级")
  private String doctorLevel;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "预约时间",index = 4) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "预约时间")
  private String numberSourceDate;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "午别",index = 5) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "午别")
  private String AMOrPM;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "时段",index = 6) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "时段")
  private String consultationPeriod;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "费用",index = 7) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "费用")
  private double numberSourceFee;

  @ColumnWidth(15) // 单列单元格宽度(该注解也可以加在类上，即声明所有单元格的宽度)
  @ExcelProperty(value = "号源状态",index = 8) // 属性设置(标题名 如果有公共标题 可以使用大括号来赋值 即{一级标题，二级标题},坐标顺序)
  @ApiModelProperty(value = "号源状态")
  private String state;
}
