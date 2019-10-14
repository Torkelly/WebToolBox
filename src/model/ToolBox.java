package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="toolbox")
public class ToolBox {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="TOOLBOX_ID")
private int toolBoxId;
@Column(name="TOOLBOX_NAME")
private String toolBoxName;
@Column(name="DATE_ADDED")
private LocalDate dateAdded;
@ManyToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="OWNER_ID")
private Owner ownerId;

@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
@JoinTable
 (
		 name="TOOLS_IN_TOOLBOX",
		 joinColumns={ @JoinColumn(name="TOOLBOX_ID", referencedColumnName="TOOLBOX_ID") },
		 inverseJoinColumns={ @JoinColumn(name="TOOL_IN_TOOLBOX_ID", referencedColumnName="TOOL_ID", unique=true) }
 )
 	private List<Tool> toolsInToolBox;

	public int getToolBoxId() {
		return toolBoxId;
	}
	public void setToolBoxId(int toolBoxId) {
		this.toolBoxId = toolBoxId;
	}
	public String getToolBoxName() {
		return toolBoxName;
	}
	public void setToolBoxName(String toolBoxName) {
		this.toolBoxName = toolBoxName;	
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Owner getOwner() {
		return ownerId;
	}
	public void setOwner(Owner owner) {
		this.ownerId = owner;
	}
	public List<Tool> getToolsInToolBox() {
		return toolsInToolBox;
	}
	public void setToolsInToolBox(List<Tool> toolsInToolBox) {
		this.toolsInToolBox = toolsInToolBox;
	}
	public ToolBox() {
		super();
	}
	
	public ToolBox(int toolBoxId, String toolBoxName, LocalDate dateAdded, Owner ownerId, List<Tool> toolsInToolBox) {
		super();
		this.toolBoxId = toolBoxId;
		this.toolBoxName = toolBoxName;
		this.dateAdded = dateAdded;
		this.ownerId = ownerId;
		this.toolsInToolBox = toolsInToolBox;
	}
	
	public ToolBox(String toolBoxName, LocalDate dateAdded, Owner ownerId, List<Tool> toolsInToolBox) {
		super();
		this.toolBoxName = toolBoxName;
		this.dateAdded = dateAdded;
		this.ownerId = ownerId;
		this.toolsInToolBox = toolsInToolBox;
	}
	
	public ToolBox(String toolBoxName, LocalDate dateAdded, Owner ownerId) {
		super();
		this.toolBoxName = toolBoxName;
		this.dateAdded = dateAdded;
		this.ownerId = ownerId;
	}
	
	@Override
	public String toString() {
		return "ToolBox [toolBoxId=" + toolBoxId + ", toolBoxName=" + toolBoxName + ", dateAdded=" + dateAdded + ", ownerId=" + ownerId + ", toolsInToolBox=" + toolsInToolBox + "]";
	}
}
