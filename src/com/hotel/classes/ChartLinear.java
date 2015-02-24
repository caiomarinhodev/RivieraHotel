/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hotel.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

/**
 *
 * @author Caio
 */
public class ChartLinear {
    
    public static JFreeChart createAJfreeChart(DefaultCategoryDataset dataset, Color background, String title, String subtitulo, String footer, String domain, String range, PlotOrientation p, boolean legenda, boolean tooltips, boolean urls){
        JFreeChart chart = ChartFactory.createLineChart(
            title, // chart title
            domain, // domain axis label
            range, // range axis label
            dataset, // data
            p, // orientation
            legenda, // include legend
            tooltips, // tooltips
            urls // urls
            );
        TextTitle source = new TextTitle(footer);
        source.setFont(new Font("SansSerif", Font.PLAIN, 10));
        source.setPosition(RectangleEdge.BOTTOM);
        source.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        chart.addSubtitle(source);
        chart.addSubtitle(new TextTitle(subtitulo));
        chart.setBackgroundPaint(background);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);
        // customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // customise the renderer...
        LineAndShapeRenderer renderer
        = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setFillPaint(Color.white);

        return chart;
    }
    
    public static ChartPanel createAChartPanelComplete(Dimension dim, DefaultCategoryDataset dataset, String title,String subtitle, String footer, String domain, String range, PlotOrientation p, boolean legenda, boolean tooltips, boolean urls){
        JFreeChart chart = createAJfreeChart(dataset, Color.WHITE, title, subtitle, footer, domain, range, p, legenda, tooltips, urls);
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


