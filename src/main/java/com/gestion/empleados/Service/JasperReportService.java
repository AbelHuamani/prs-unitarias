package com.gestion.empleados.Service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private DatabaseClient databaseClient;

    public Mono<byte[]> generateReport() {
        return fetchReportData().flatMap(data -> {
            try {
                Resource resource = resourceLoader.getResource("classpath:vista.jrxml");
                InputStream inputStream = resource.getInputStream();

                JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
                JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
                return Mono.just(JasperExportManager.exportReportToPdf(jasperPrint));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return Mono.error(e);
            }
        });
    }

    private Mono<List<Map<String, Object>>> fetchReportData() {
        return databaseClient.sql("SELECT vista_menu_comida_historial.menuid,\n" +
                        "\tcomidas.menuid,\n" +
                        "\tvista_menu_comida_historial.nombremenu,\n" +
                        "\tvista_menu_comida_historial.id,\n" +
                        "\tvista_menu_comida_historial.nombrecomida,\n" +
                        "\tvista_menu_comida_historial.precio,\n" +
                        "\tvista_menu_comida_historial.categoria\n" +
                        "FROM comidas\n" +
                        "\tINNER JOIN menus ON \n" +
                        "\t comidas.menuid = menus.menuid ,\n" +
                        "\tvista_menu_comida_historial")
                .fetch()
                .all()
                .collectList();
    }
}
