/**
 * 
 */
package com.jccg.schedules.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Cristian Gerardo Jaramillo Cruz
 */
@Entity
@Table(name="schedules")
@XmlRootElement
public class Schedule extends Model
{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
    @Column(name="group_collection_id")
    private Long groupCollectionId;
    @Column(name="day_of_class")
    private Integer dayOfClass;
    private String building;
    private String classroom;
    @Column(name="class_start")
    @Temporal(TemporalType.TIME)
    private Date classStart;
    @Temporal(TemporalType.TIME)
    @Column(name="to_class")
    private Date toClass;

    /**
     *
     */
    public Schedule() 
    {
        super();
    }
    
    /**
     *
     * @param id
     * @param groupCollectionId
     * @param dayOfClass
     * @param building
     * @param classroom
     * @param classStart
     * @param toClass
     */
    public Schedule(Long id, Long groupCollectionId, Integer dayOfClass, String building, String classroom, Date classStart, Date toClass) 
    {
        this();
        this.id = id;
        this.groupCollectionId = groupCollectionId;
        this.dayOfClass = dayOfClass;
        this.building = building;
        this.classroom = classroom;
        this.classStart = classStart;
        this.toClass = toClass;
    }
    
    /**
     *
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     *
     * @return 
     */
    public Long getGroupCollectionId() {
        return groupCollectionId;
    }

    /**
     *
     * @param groupCollectionId
     */
    public void setGroupCollectionId(Long groupCollectionId) {
        this.groupCollectionId = groupCollectionId;
    }

    /**
     *
     * @return
     */
    public Integer getDayOfClass()
    {
        return dayOfClass;
    }

    /**
     *
     * @param dayOfClass
     */
    public void setDayOfClass(Integer dayOfClass)
    {
        this.dayOfClass = dayOfClass;
    }

    /**
     *
     * @return
     */
    public String getBuilding()
    {
        return building;
    }

    /**
     *
     * @param building
     */
    public void setBuilding(String building)
    {
        this.building = building;
    }

    /**
     *
     * @return
     */
    public String getClassroom()
    {
        return classroom;
    }

    /**
     *
     * @param classroom
     */
    public void setClassroom(String classroom)
    {
        this.classroom = classroom;
    }

    /**
     *
     * @return
     */
    public Date getClassStart()
    {
        return classStart;
    }

    /**
     *
     * @param classStart
     */
    public void setClassStart(Date classStart)
    {
        this.classStart = classStart;
    }

    /**
     *
     * @return
     */
    public Date getToClass()
    {
        return toClass;
    }

    /**
     *
     * @param toClass
     */
    public void setToClass(Date toClass)
    {
        this.toClass = toClass;
    }

}
