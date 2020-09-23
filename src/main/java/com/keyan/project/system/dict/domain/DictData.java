package com.keyan.project.system.dict.domain;

import com.keyan.framework.aspectj.lang.annotation.Excel;
import com.keyan.framework.web.domain.BaseEntity;

/**
 * 字典数据表 sys_dict_data
 * 
 * @author ruoyi
 */
public class DictData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字典编码 */
    @Excel(name = "字典编码", column = "A")
    private Long dictCode;

    /** 字典排序 */
    @Excel(name = "字典排序", column = "B")
    private Long dictSort;

    /** 字典标签 */
    @Excel(name = "字典标签", column = "C")
    private String dictLabel;

    /** 字典键值 */
    @Excel(name = "字典键值", column = "D")
    private String dictValue;

    /** 字典类型 */
    @Excel(name = "字典类型", column = "E")
    private String dictType;

    /** 字典样式 */
    @Excel(name = "字典样式", column = "F")
    private String cssClass;

    /** 是否默认（Y是 N否） */
    @Excel(name = "是否默认", column = "G")
    private String isDefault;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", column = "H")
    private String status;

    public Long getDictCode()
    {
        return dictCode;
    }

    public void setDictCode(Long dictCode)
    {
        this.dictCode = dictCode;
    }

    public Long getDictSort()
    {
        return dictSort;
    }

    public void setDictSort(Long dictSort)
    {
        this.dictSort = dictSort;
    }

    public String getDictLabel()
    {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel)
    {
        this.dictLabel = dictLabel;
    }

    public String getDictValue()
    {
        return dictValue;
    }

    public void setDictValue(String dictValue)
    {
        this.dictValue = dictValue;
    }

    public String getDictType()
    {
        return dictType;
    }

    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    public String getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "DictData [dictCode=" + dictCode + ", dictSort=" + dictSort + ", dictLabel=" + dictLabel + ", dictValue="
                + dictValue + ", dictType=" + dictType + ", cssClass=" + cssClass + ", isDefault=" + isDefault
                + ", status=" + status + "]";
    }

}
