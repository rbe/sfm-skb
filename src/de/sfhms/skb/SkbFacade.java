package de.sfhms.skb;

import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import de.sfhms.skb.output.MyOutput;
import de.sfhms.skb.processor.ProcessorException;
import de.sfhms.skb.processor.plugin.PluginExecutor;
import java.sql.SQLException;

public class SkbFacade {

    public SkbFacade() {
    }

    public static void main(String[] args) throws ProcessorException, SQLException {
        SkbConfig config = SkbConfig.getInstance();
        config.setActualJob(config.getJobByName("GCH"));
//        System.out.println(config.getActualJob().getName());
//        System.out.println("ds´   "+config.getDatasourceByName(config.getActualJob(), "mysql").getUrl());
//        PluginExecutor pe = new PluginExecutor();
//        pe.fireInputPlugins();
        MyDatamodel model = new MyDatamodel();
        model.setName("Test");
        MyRow r1 = new MyRow();
        MyCell d1 = new MyCell("Name", "Czigalla");
        MyCell d2 = new MyCell("Vorname", "Sebastian");
        MyCell d3 = new MyCell("PLZ", "48150");
        MyCell d4 = new MyCell("Ort", "Münster");
        MyCell e1 = new MyCell("Name", "Deukers");
        MyCell e2 = new MyCell("Vorname", "Frank");
        MyCell e3 = new MyCell("PLZ", "48151");
        MyCell e4 = new MyCell("Ort", "Münster");
        MyCell c1 = new MyCell("Name", "Brandes");
        MyCell c2 = new MyCell("Vorname", "Tim");
        MyCell c3 = new MyCell("PLZ", "48149");
        MyCell c4 = new MyCell("Ort", "Münster");
        r1.addCell(c1);
        r1.addCell(c2);
        r1.addCell(c3);
        r1.addCell(c4);
        model.addRow(r1);
        MyRow r2 = new MyRow();
        r2.addCell(d1);
        r2.addCell(d2);
        r2.addCell(d3);
        r2.addCell(d4);
        model.addRow(r2);
        MyRow r3 = new MyRow();
        r3.addCell(e1);
        r3.addCell(e2);
        r3.addCell(e3);
        r3.addCell(e4);
        model.addRow(r3);
        MyRow r4 = new MyRow();
        MyCell f1 = new MyCell("Name", "Elland");
        MyCell f2 = new MyCell("Vorname", "Hans");
        MyCell f3 = new MyCell("PLZ", "48153");
        r4.addCell(f1);
        r4.addCell(f2);
        r4.addCell(f3);
        r4.addCell(new MyCell("Ort", "Münster"));
        model.addRow(r4);
        MyOutput.toDatabase(model);
    }
}

