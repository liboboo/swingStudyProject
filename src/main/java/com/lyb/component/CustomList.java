package com.lyb.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author lyb
 * @version 1.0
 * @description: TODO
 * @date 2023/7/9 21:36
 */
public class CustomList extends JList {

    public CustomList(ListModel<String> dataModel) {
        super(dataModel);
        setCellRenderer(new MyRenderer());
    }

    private static class MyRenderer extends JComponent implements ListCellRenderer<String>{

        private Font font=new Font(Font.SANS_SERIF,Font.PLAIN,18);
        private String text;
        private int index;
        private Color evenColor=Color.LIGHT_GRAY;
        private Color oddColor=new Color(34,134,235);
        private Color selectedColor=Color.RED;
        private Color background;

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            text=value;

            list.setSelectionBackground(selectedColor);
            this.index=index;
            background=isSelected?selectedColor:index%2==0?evenColor:oddColor;
            return this;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            FontMetrics fm = g.getFontMetrics(font);
            g.setColor(background);
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(Color.GREEN);
            g.drawString(text,fm.stringWidth("O"),fm.getAscent());
            Graphics2D gs=(Graphics2D) g;
            gs.drawString("O",index%2==0?0:fm.stringWidth(text)+fm.stringWidth("O"),fm.getAscent());
        }

        @Override
        public Dimension getPreferredSize() {
            FontMetrics fontMetrics = getGraphics().getFontMetrics(font);
            return new Dimension(fontMetrics.stringWidth(text)+2*fontMetrics.stringWidth("O"),fontMetrics.getHeight());
        }
    }
}
