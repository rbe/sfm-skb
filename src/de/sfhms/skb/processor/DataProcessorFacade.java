package de.sfhms.skb.processor;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.5F7DBD7B-6C75-6FEF-4763-B4342CFD1885]
// </editor-fold> 
public class DataProcessorFacade {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.11AA89EA-BEEC-C446-0C29-4B6C36E94962]
    // </editor-fold> 
    private PluginExecutor pluginExecutor;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AAFDFB06-6EC0-9190-B877-D7B8077EF9AA]
    // </editor-fold> 
    public DataProcessorFacade () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.61351C5F-0275-64F3-0602-169F9D7CB391]
    // </editor-fold> 
    public void firePlugins () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3C773624-4C3F-6E3B-6C7C-9CEF2E415065]
    // </editor-fold> 
    public void setConfiguration () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.96508BC9-DCDB-2618-5920-C6B7B9B1C51F]
    // </editor-fold> 
    public PluginExecutor getPluginExecutor () {
        return pluginExecutor;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.F2128771-6774-2032-2A29-2DF1A12BA98F]
    // </editor-fold> 
    public void setPluginExecutor (PluginExecutor val) {
        this.pluginExecutor = val;
    }

}

