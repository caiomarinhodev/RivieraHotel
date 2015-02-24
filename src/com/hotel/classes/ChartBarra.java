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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Caio
 */
public class ChartBarra {
    
    public static JFreeChart createAJfreeChart3D(DefaultCategoryDataset dataset, String title, String domain, String range, PlotOrientation p, boolean legenda, boolean tooltips, boolean urls){
        JFreeChart chart = ChartFactory.createBarChart3D(
        title, // chart title
        domain, // domain axis label
        range, // range axis label
        dataset, // data
        p, // orientation
        legenda, // include legend
        tooltips, // tooltips?
        urls // URLs?
        );
        return chart;
    }
    
    public static ChartPanel createAChartPanelComplete3D(Dimension dim, DefaultCategoryDataset dataset, String title, String domain, String range, PlotOrientation p, boolean legenda, boolean tooltips, boolean urls){
        JFreeChart chart = createAJfreeChart3D(dataset, title, domain, range, p, legenda, tooltips, urls);
        
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


