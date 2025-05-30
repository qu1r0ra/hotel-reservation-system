package Hotel;

import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelHotelSelection extends JPanel{
    private JLabel selectedHotel;
    private JTextArea hotelList;
    private JLabel selectionMode;
    private JButton btnSelectHotel;
    private JButton btnNextHotel;
    private JButton btnPrevHotel;

    PanelHotelSelection(ComponentFactory compFactory){
        ComponentBuilderDirector director = new ComponentBuilderDirector(ComponentBuilderState.LAY_BOX_VERTICAL);
        CompBuilderBoxLayout boxBuildVert = ((CompBuilderBoxLayout) director.getBuilder());
        boxBuildVert.setSpacing(50);
        boxBuildVert.setAutoSpace(false);
        initHotelSelectionPanel(boxBuildVert, compFactory);
        this.setVisible(true);
    }

    private void initHotelSelectionPanel(CompBuilderBoxLayout boxBuildVert, ComponentFactory compFactory) {
        this.setBackground(compFactory.getRandomColor());
        this.setBorder(compFactory.createPadding());
        JPanel responsePanel = compFactory.createJPanel();
        JTextArea hotelList = compFactory.createJTextArea();
        JScrollPane hotelListScrollPane = compFactory.createJScrollPane(hotelList);

        JLabel selectedHotel = compFactory.createJLabelBody("None selected");
        JLabel selectionMode = compFactory.createJLabelBody("Hotel above Selected");
        JButton btnSelectHotel = compFactory.createSingleJButton("Select Hotel");
        JButton btnNextButton = compFactory.createSingleJButton(">");
        JButton btnPrevButton = compFactory.createSingleJButton("<");
        
        selectionMode.setVisible(false);
        hotelList.setEditable(false);

        this.hotelList = hotelList;
        this.selectedHotel = selectedHotel;
        this.selectionMode = selectionMode;

        btnSelectHotel.setEnabled(false);
        btnNextButton.setEnabled(false);
        btnPrevButton.setEnabled(false);

        this.btnSelectHotel = btnSelectHotel;
        this.btnNextHotel = btnNextButton;
        this.btnPrevHotel = btnPrevButton;

        GroupLayout layout = new GroupLayout(responsePanel);
        responsePanel.setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addComponent(btnPrevButton)
            .addComponent(btnNextButton)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup()
                .addComponent(btnPrevButton)
                .addComponent(btnNextButton)
            )
        );

        boxBuildVert.setParent(this);
        boxBuildVert.setChild(compFactory.createJLabelHeading("Select Hotel"));
        boxBuildVert.setChild(selectedHotel);
        boxBuildVert.setChild(responsePanel);
        boxBuildVert.setChild(btnSelectHotel);
        boxBuildVert.setChild(selectionMode);
        boxBuildVert.setChild(compFactory.createJLabelHeading("Hotels:"));
        boxBuildVert.setChild(hotelListScrollPane);
        
    }

    public void setSelectionVisible(boolean enabled){
        this.selectionMode.setVisible(enabled);
    }

    public void setActionListener(ActionListener listener){
        btnSelectHotel.addActionListener(listener);
        btnNextHotel.addActionListener(listener);
        btnPrevHotel.addActionListener(listener);
        
    }

    public void setSelectedHotel(String text) {
        this.selectedHotel.setText(text);
    }

    public void setHotelList(String text) {
        this.hotelList.setText(text);
    }

    public void setBtnNextHotelEnable(Boolean enable){
        this.btnNextHotel.setEnabled(enable);
    }

    public void setBtnPrevHotelEnable(Boolean enable){
        this.btnPrevHotel.setEnabled(enable);
    }

    public void setBtnSelectHotel(Boolean enable){
        this.btnSelectHotel.setEnabled(enable);
    }
}
