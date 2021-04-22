package com.wj5633.ch05.model;

import java.util.Date;

/**
 * Database Table Remarks:
 *   权限表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sys_privilege
 */
public class SysPrivilege {
    /**
     * Database Column Remarks:
     *   权限 ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   权限名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.privilege_name
     *
     * @mbg.generated
     */
    private String privilegeName;

    /**
     * Database Column Remarks:
     *   权限 URL
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.privilege_url
     *
     * @mbg.generated
     */
    private String privilegeUrl;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_privilege.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.id
     *
     * @return the value of sys_privilege.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.id
     *
     * @param id the value for sys_privilege.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.privilege_name
     *
     * @return the value of sys_privilege.privilege_name
     *
     * @mbg.generated
     */
    public String getPrivilegeName() {
        return privilegeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.privilege_name
     *
     * @param privilegeName the value for sys_privilege.privilege_name
     *
     * @mbg.generated
     */
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName == null ? null : privilegeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.privilege_url
     *
     * @return the value of sys_privilege.privilege_url
     *
     * @mbg.generated
     */
    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.privilege_url
     *
     * @param privilegeUrl the value for sys_privilege.privilege_url
     *
     * @mbg.generated
     */
    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl == null ? null : privilegeUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_privilege.create_time
     *
     * @return the value of sys_privilege.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_privilege.create_time
     *
     * @param createTime the value for sys_privilege.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}