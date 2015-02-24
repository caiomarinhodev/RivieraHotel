/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.classes;

import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Caio
 */
public class ChartPizza {
    
    public static JFreeChart createAJfreeChart3D(DefaultPieDataset dataset, String title, boolean legenda, boolean tooltips, boolean urls){
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, legenda, tooltips, urls);
        return chart;
    }
    
    public static ChartPanel createAChartPanelComplete3D(Dimension dim,DefaultPieDataset dataset, String title, boolean legenda, boolean tooltips, boolean urls){
        JFreeChart chart = createAJfreeChart3D(dataset, title, legenda, tooltips, urls);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(dim);
        return chartPanel;
    }
    
    public static JFrame createAJframe(ChartPanel cp, Dimension d){
        JFrame j = new JFrame();
        j.setLocationRelativeTo(null);
        if(d!=null){
           j.setSize(d); 
        }else{
            j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
        j.add(cp);
        j.validate();
        return j;
    }

}


