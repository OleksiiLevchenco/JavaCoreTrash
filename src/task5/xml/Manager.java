package task5.xml;

import task5.xml.JaxbParser.JaxbParser;
import task5.xml.JaxbParser.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Alexey Levchenko
 */
public class Manager {

    private String filePass;
    private File file;
    private TransformersCatalog catalog;
    private Parser parser = new JaxbParser();
    private Map<Integer, Transformer> cache = new HashMap<>();
    private Map<Integer, List<Transformer>> outputVoltageIndex;
    private Map<BigDecimal, List<Transformer>> priceIndex;

    public Manager() throws JAXBException {
        filePass = "TransformersCatalog.xml";
        file = new File(filePass);
        loadAll();
    }


    public void add(Transformer transformer) throws JAXBException {
        if (!cache.containsKey(transformer.getId())) {
            cache.put(transformer.getId(), transformer);
            System.out.println("Transformer successfully added\n" + transformer);
            indexing();
            flush();
        } else {
            System.out.println("This transformer already exist! \n");
        }
    }

    public Transformer loadById(int id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        } else {
            System.out.println("Transformer with such ID is not exist! \n");
            return new NullTransformer();
        }
    }

    public void replace(Transformer transformer) throws JAXBException {
        if (cache.containsKey(transformer.getId())) {
            System.out.println(cache.get(transformer.getId())+"\n replaced by \n" + transformer + "\n");
            cache.replace(transformer.getId(), transformer);
            flush();
        } else {
            System.out.println("Transformer with such ID is not exist! \n");
        }
    }

    public void remove(int id) throws JAXBException {
        if (cache.containsKey(id)) {
            System.out.println("Transformer \n" + cache.get(id) + " - removed \n");
            cache.remove(id);
            flush();
        } else {
            System.out.println("Transformer with such ID is not exist! \n");
        }
    }

    public List<Transformer> findByOutputVoltage(int voltage) {
        return outputVoltageIndex.get(voltage);
    }

    public List<Transformer> findByPrice(BigDecimal price) {
        return priceIndex.get(price);
    }



    private void flush() throws JAXBException {
        catalog.getBase().clear();
        for (Transformer t : cache.values()) {
            catalog.getBase().add(t);
        }
        parser.saveObject(file, catalog);
    }

    private void loadAll() throws JAXBException, ClassCastException {
        if (file.exists() && !file.isDirectory()) {
            this.catalog = (TransformersCatalog) parser.getObject(file, TransformersCatalog.class);
            for (Transformer t : catalog.getBase()) {
                cache.put(t.getId(), t);
            }
            indexing();
        } else {
            catalog = new TransformersCatalog();
            flush();
            loadAll();
        }
    }

    private void outputVoltageIndexing() {
        outputVoltageIndex = new TreeMap<>();
        if (!cache.isEmpty()) {
            for (Transformer transformer : cache.values()) {
            if (outputVoltageIndex.get(transformer.getOutputVoltage()) == null) {
                outputVoltageIndex.put(transformer.getOutputVoltage(), new ArrayList<Transformer>());
            }
            outputVoltageIndex.get(transformer.getOutputVoltage()).add(transformer);
            }
        }
    }

    private void priceIndexing() {
        priceIndex = new TreeMap<>();
        for (Transformer transformer : cache.values()){
            if (priceIndex.get(transformer.getPrice())==null){
                priceIndex.put(transformer.getPrice(), new ArrayList<Transformer>());
            }
            priceIndex.get(transformer.getPrice()).add(transformer);
        }
    }

    private void indexing(){
        outputVoltageIndexing();
        priceIndexing();
    }

}
