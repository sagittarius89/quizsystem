package quizsystem.gui.windows.addquestion.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


import java.awt.event.ActionListener;

import quizsystem.gui.abs.AbstractModel;
import quizsystem.gui.windows.addquestion.controller.AddQuestionControllerAbstract;
import quizsystem.gui.windows.addquestion.controller.MultipleChoiceTestController;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;
import quizsystem.gui.windows.addquestion.model.MultipleChoiceTestQuestionModel;

public class MultipleChoiceTestQuestionView extends AddQuestionViewAbstract {
	private static final long serialVersionUID = 1L;
	private static final String CORRECT_COL = "Correct?";
	private static final String ANSWER_COL = "Answer text";
	private DefaultTableModel tableModel;
	private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	
	class CheckBoxRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (value == null)
				return null;
			return (Component) value;
		}
	}
	
	class CheckBoxEditor extends DefaultCellEditor implements ItemListener {

		private static final long serialVersionUID = 1L;

		private JCheckBox checkBox;

		public CheckBoxEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			if (value == null)
				return null;
			checkBox = (JCheckBox) value;
			checkBox.addItemListener(this);
			return (Component) value;
		}

		public Object getCellEditorValue() {
			checkBox.removeItemListener(this);
			return checkBox;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			super.fireEditingStopped();
		}
	}
	
	class CheckBoxActionListener implements ActionListener {
		private JCheckBox checkBox;
		
		public CheckBoxActionListener(JCheckBox checkBox) {
			this.checkBox = checkBox;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			((MultipleChoiceTestQuestionModel)model).toggleAnswer(checkBoxes.indexOf(checkBox));

			tableModel.fireTableDataChanged();
		}
		
	}
		
	
	public MultipleChoiceTestQuestionView(
			AddQuestionControllerAbstract controller,
			final AddQuestionModelAbstract model) {
		super(controller, model);
		
		this.answerPanel.setLayout(new BoxLayout(this.answerPanel, BoxLayout.Y_AXIS));
		
		final JTable table = new JTable();
		
		tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		
		tableModel.addColumn(CORRECT_COL);
		tableModel.addColumn(ANSWER_COL);
		
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent arg0) {
				try {
					String text = (String)tableModel.getValueAt(arg0.getFirstRow(),arg0.getColumn());
					Integer idx = arg0.getFirstRow();
					
					((MultipleChoiceTestQuestionModel)model).setAnswer(idx, text);
				} catch(Exception e) {
					
				}
			}
		});
		
		table.getColumn(CORRECT_COL).setCellEditor(new CheckBoxEditor(new JCheckBox()));
		table.getColumn(CORRECT_COL).setCellRenderer(new CheckBoxRenderer());
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		
		JPanel buttonsBox = new JPanel();
		buttonsBox.setLayout(new FlowLayout());
		
		JButton addButton = new JButton("Add");
		JButton removeButton = new JButton("Remove");
		JButton setButton = new JButton("Set above");
		
		addButton.addActionListener(new ActionListener() {			
						
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String text = JOptionPane.showInputDialog("Answer text");
				((MultipleChoiceTestQuestionModel)model).addAnswer(text);
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Integer idx = table.getSelectedRow();
				
				if(idx<0 || idx>=tableModel.getRowCount())
					return;
				
				((MultipleChoiceTestQuestionModel)model).removeAnswer(idx);
			}
		});
		
		setButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idx = table.getSelectedRow();
				String text = JOptionPane.showInputDialog("Answer text");
				((MultipleChoiceTestQuestionModel)model).putAnswer(idx, text);
			}
		});
		
		buttonsBox.add(addButton);
		buttonsBox.add(removeButton);
		buttonsBox.add(setButton);
		
		this.answerPanel.add(scrollPane);
		this.answerPanel.add(buttonsBox);
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
		
		String n = evt.getPropertyName();
		
		if(n.equals(MultipleChoiceTestController.ANSWER)) {
			String m = (String)evt.getOldValue();
			if(m.equals(AbstractModel.PROPERTY_ADDED)) {
				JCheckBox button = new JCheckBox();
				button.addActionListener(new CheckBoxActionListener(button));
				tableModel.addRow( new Object[] {button, evt.getNewValue() + ""} );
				checkBoxes.add(button);
			} else if(m.equals(AbstractModel.PROPERTY_REMOVED)) {
				checkBoxes.remove((Integer)evt.getNewValue());
				tableModel.removeRow((Integer)evt.getNewValue());
			}
		} else if(n.equals(MultipleChoiceTestController.KEY)) {
			IndexedPropertyChangeEvent ievt = (IndexedPropertyChangeEvent)evt;
			JCheckBox cb = checkBoxes.get(ievt.getIndex());
			cb.setSelected((Boolean)evt.getNewValue());
		} else if(n.equals(MultipleChoiceTestController.ANSWER_SET)) {
			IndexedPropertyChangeEvent ievt = (IndexedPropertyChangeEvent)evt;
			tableModel.setValueAt(ievt.getNewValue() ,ievt.getIndex(), 2);		
		} else if(n.equals(MultipleChoiceTestController.ANSWER_PUT)) {
			IndexedPropertyChangeEvent ievt = (IndexedPropertyChangeEvent)evt;
			JCheckBox button = new JCheckBox();
			button.addActionListener(new CheckBoxActionListener(button));
			checkBoxes.add(button);
			tableModel.insertRow(ievt.getIndex(), new Object[] {button, evt.getNewValue() + ""});	
		}
	}
}
