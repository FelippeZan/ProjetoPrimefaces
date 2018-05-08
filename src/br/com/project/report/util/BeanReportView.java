package br.com.project.report.util;

import java.io.Serializable;

import org.primefaces.model.StreamedContent;
import org.springframework.stereotype.Component;

import br.com.project.util.all.BeanViewAbstract;

@Component
public abstract class BeanReportView extends BeanViewAbstract implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected StreamedContent arquivoReport;
	protected int tipoRelatorio;
	
	
	
}
