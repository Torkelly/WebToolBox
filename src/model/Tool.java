package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tools")

public class Tool {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TOOL_ID")
	private int toolId;
	@Column(name="TOOL_NAME")
	private String toolName;
	
	public Tool() {
		super();
	}
	
	public Tool(int toolId, String toolName) {
		super();
		this.toolId = toolId;
		this.toolName = toolName;
	}
	
	public Tool(String toolName) {
		super();
		this.toolName = toolName;
	}

	public int getToolId() {
		return toolId;
	}

	public void setToolId(int toolId) {
		this.toolId = toolId;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}
	
	@Override
	public String toString() {
	    return "Tool [id=" + toolId + ", toolName=" + toolName + "]";
	}
}