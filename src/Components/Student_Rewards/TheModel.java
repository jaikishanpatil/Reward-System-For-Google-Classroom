package Components.Student_Rewards;


import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

public class TheModel extends AbstractTableModel{
	
	private String[] columns;
	private Object[] [] rows;

	public TheModel(Object[][] rows,String[] columns ) {
		
		this.columns = columns;
		this.rows = rows;
	}

	public Class getColumnClass(int column){
		if(column==4){
			return Icon.class;
		}else{
			return getValueAt(0,column).getClass();
		}
	}
	@Override
	public int getColumnCount() {
		
		return this.columns.length;
	}

	@Override
	public int getRowCount() {

		return this.rows.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return this.rows[rowIndex][columnIndex];
	}

	public String getColumnName(int col){
		return this.columns[col];
	}
}
