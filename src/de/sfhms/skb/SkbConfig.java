package de.sfhms.skb;

import de.sfhms.skb.jaxb.config.Skb;

public class SkbConfig {

    private Skb config;
    private Skb.Job actualJob;
    private String actualJobName;

    /**
     * Initalization-on-demand-holder Idiom
     */
    private static class Holder {

        private static final SkbConfig INSTANCE = new SkbConfig();
    }

    private SkbConfig() {
        config = new Skb();
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(config.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            config = (Skb) unmarshaller.unmarshal(SkbConfig.class.getResourceAsStream("/config1.xml")); //NOI18N
//            System.out.println("" + config.getJob().get(0).getName());
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
    }

    public static SkbConfig getInstance() {
        return Holder.INSTANCE;
    }

    public Skb getConfig() {
        return config;
    }

    public Skb.Job getActualJob() {
        return actualJob;
    }

    public void setActualJob(Skb.Job actualJob) {
        this.actualJob = actualJob;
        actualJobName = actualJob.getName();
    }

    public String getActualJobName() {
        return actualJobName;
    }

    public Skb.Job getJobByName(String name) {
        Skb.Job r = null;
        for (Skb.Job job : config.getJob()) {
            if (name.equals(job.getName())) {
                r = job;
                break;
            }
        }
        return r;
    }

    public Skb.Job.Datasource getDatasourceByName(Skb.Job job, String name) {
        Skb.Job.Datasource r = null;
        for (Skb.Job.Datasource ds : job.getDatasource()) {
            if (name.equals(ds.getName())) {
                r = ds;
                break;
            }
        }
        return r;
    }
}
