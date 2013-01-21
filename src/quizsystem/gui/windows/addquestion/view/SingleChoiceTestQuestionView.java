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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


import java.awt.event.ActionListener;

import quizsystem.gui.abs.AbstractModel;
import quizsystem.gui.windows.addquestion.controller.AddQuestionControllerAbstract;
import quizsystem.gui.windows.addquestion.controller.SingleChoiceTestController;
import quizsystem.gui.windows.addquestion.model.AddQuestionModelAbstract;
import quizsystem.gui.windows.addquestion.model.SingleChoiceTestQuestionModel;

public class SingleChoiceTestQuestionView extends AddQuestionViewAbstract {
	private static final String CORRECT_COL = "Correct?";
	private static final String ANSWER_COL = "Answer text";
	private DefaultTableModel tableModel;
	private ArrayList<JRadioButton> buttons = new ArrayList<JRadioButton>();
	
	class RadioButtonRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			if (value == null)
				return null;
			return (Component) value;
		}
	}
	
	class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
		private JRadioButton button;

		public RadioButtonEditor(JCheckBox checkBox) {
			super(checkBox);
		}

		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {
			if (value == null)
				return null;
			button = (JRadioButton) value;
			button.addItemListener(this);
			return (Component) value;
		}

		public Object getCellEditorValue() {
			button.removeItemListener(this);
			return button;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {
			super.fireEditingStopped();
		}
	}
	
	class RadioButtonActionListener implements ActionListener {
		private JRadioButton button;
		
		public RadioButtonActionListener(JRadioButton button) {
			this.button = button;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			((SingleChoiceTestQuestionModel)model).setCorrectAnswer(buttons.indexOf(button));
			for(JRadioButton b: buttons) {
				b.setSelected(b.equals(button));
			}
			
			tableModel.fireTableDataChanged();
		}
		
	}
		
	
	public SingleChoiceTestQuestionView(
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
					
					((SingleChoiceTestQuestionModel)model).setAnswer(idx, text);
				} catch(Exception e) {
					
				}
			}
		});
		
		table.getColumn(CORRECT_COL).setCellEditor(new RadioButtonEditor(new JCheckBox()));
		table.getColumn(CORRECT_COL).setCellRenderer(new RadioButtonRenderer());
		
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
				((SingleChoiceTestQuestionModel)model).addAnswer(text);
			}
		});
		
		removeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Integer idx = table.getSelectedRow();
				
				if(idx<0 || idx>=tableModel.getRowCount())
					return;
				
				((SingleChoiceTestQuestionModel)model).removeAnswer(idx);
			}
		});
		
		setButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idx = table.getSelectedRow();
				String text = JOptionPane.showInputDialog("Answer text");
				((SingleChoiceTestQuestionModel)model).putAnswer(idx, text);
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
		
		if(n.equals(SingleChoiceTestController.ANSWER)) {
			String m = (String)evt.getOldValue();
			if(m.equals(AbstractModel.PROPERTY_ADDED)) {
				JRadioButton button = new JRadioButton();
				button.addActionListener(new RadioButtonActionListener(button));
				tableModel.addRow( new Object[] {button, evt.getNewValue() + ""} );
				buttons.add(button);
			} else if(m.equals(AbstractModel.PROPERTY_REMOVED)) {
				buttons.remove((Integer)evt.getNewValue());
				tableModel.removeRow((Integer)evt.getNewValue());
			}
		} else if(n.equals(SingleChoiceTestController.KEY)) {
			JRadioButton button = buttons.get((Integer)evt.getNewValue());
			for(JRadioButton b: buttons)
				b.setSelected(b.equals(button));
		} else if(n.equals(SingleChoiceTestController.ANSWER_SET)) {
			IndexedPropertyChangeEvent ievt = (IndexedPropertyChangeEvent)evt;
			tableModel.setValueAt(ievt.getNewValue() ,ievt.getIndex(), 2);		
		} else if(n.equals(SingleChoiceTestController.ANSWER_PUT)) {
			IndexedPropertyChangeEvent ievt = (IndexedPropertyChangeEvent)evt;
			JRadioButton button = new JRadioButton();
			button.addActionListener(new RadioButtonActionListener(button));
			buttons.add(button);
			tableModel.insertRow(ievt.getIndex(), new Object[] {button, evt.getNewValue() + ""});
			
				
		}
	}

}
