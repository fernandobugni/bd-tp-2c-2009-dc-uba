package ubadbtools.recoveryLogAnalyzer.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import ubadbtools.recoveryLogAnalyzer.logRecords.CheckPointEndLogRecord;
import ubadbtools.recoveryLogAnalyzer.logRecords.CheckPointStartLogRecord;
import ubadbtools.recoveryLogAnalyzer.logRecords.CommitLogRecord;
import ubadbtools.recoveryLogAnalyzer.logRecords.RecoveryLogRecord;
import ubadbtools.recoveryLogAnalyzer.logRecords.StartLogRecord;
import ubadbtools.recoveryLogAnalyzer.logRecords.UpdateLogRecord;
import ubadbtools.recoveryLogAnalyzer.results.RecoveryResult;
import ubadbtools.recoveryLogAnalyzer.results.ValidationResult;

public class RecoveryLog
{
	//[start] Atributos
	private List<RecoveryLogRecord> logRecords;
	private Set<String> items;	//Uso sets para evitar repetidos
	private Set<String> transactions;
	//[end]
	
	//[start] Constructor
	public RecoveryLog()
	{
		logRecords 	= new ArrayList<RecoveryLogRecord>();
		items 		= new LinkedHashSet<String>();	//Uso esta clase porque me provee un orden de iteración predecible (no como HashSet)
		transactions= new LinkedHashSet<String>();
	}
	//[end]

	//[start] Getters
	public List<RecoveryLogRecord> getLogRecords()
	{
		return logRecords;
	}
	
	public Set<String> getItems()
	{
		return items;
	}

	public Set<String> getTransactions()
	{
		return transactions;
	}
	//[end]
	
	//[start] Add
	public void addLogRecord(RecoveryLogRecord logRecord)
	{
		logRecords.add(logRecord);
	}
	
	public void addItem(String item)
	{
		items.add(item);
	}

	public void addTransaction(String transaction)
	{
		transactions.add(transaction);
	}
	//[end]

	//[start] replaceLogRecord
	public void replaceLogRecord(int position, RecoveryLogRecord logRecord)
	{
		logRecords.set(position, logRecord);
	}
	//[end]
	
	//[start] Validate
	public ValidationResult validate()
	{
		//TODO: Completar
		return null;
	}
	//[end]
	
	//[start] RecoverFromCrash
	public RecoveryResult recoverFromCrash()
	{
		//TODO: ESTO LO HIZO EL GOOONZA
		RecoveryResult result = new RecoveryResult();
		RecoveryLogRecord currentElem = null;
		String currentTransaction = null;
		HashSet<String> transactionsCommited = new HashSet<String>();
		boolean checkPoinEndFound = false;
		ListIterator<RecoveryLogRecord> it = (ListIterator<RecoveryLogRecord>) logRecords.listIterator(logRecords.size());
		while (it.hasPrevious())
		{
				currentElem = it.previous();
				currentTransaction = currentElem.getTransaction();
				
				// COMMIT RECORD?
				if (currentElem instanceof CommitLogRecord)
				{
					transactionsCommited.add( currentTransaction );
				
				} else if (currentElem instanceof StartLogRecord && 
							transactionsCommited.contains(currentTransaction))
				{
					/*
					 * La transaccion fue comiteada correctamente. Tengo que sacarla de "transactionsCommited"
					 * para contemplar el caso en que en un mismo log hubiera otra transaccion con
					 * este nombre que podria no hacer commit  
					 */
					transactionsCommited.remove(currentTransaction);
					
				} else if (currentElem instanceof StartLogRecord &&
						!transactionsCommited.contains(currentTransaction))
				{
					/*
					 * Llegue al start de una transaccion que no hizo commit, hubo que rollbackearla
					 */
					result.addItem("Agregar un Abort al log para la transaccion " + currentTransaction);
				// UPDATE RECORD?
				} else if (currentElem instanceof UpdateLogRecord &&
							!transactionsCommited.contains(currentTransaction))
				{
					/*
					 * La transaccion no fue comiteada, de modo que hay que revertir el valor del item
					 */
					UpdateLogRecord item = (UpdateLogRecord) currentElem;
					result.addItem( "Restaurar el item " + item.getItem() + " al valor " + 
									item.getOldValue() + " en la transaccion " + currentTransaction);
					
				} else if (currentElem instanceof UpdateLogRecord &&
							transactionsCommited.contains(currentTransaction))
					/*
					 * La transaccion fue comiteada, de modo que no hay que restaurar nada
					 */
				{
					continue;
					
				// USEFULL CHECKPOINT START RECORD?
				} else if (currentElem instanceof CheckPointStartLogRecord && checkPoinEndFound)
				{
					/*
					 * Como previo al CheckPointStartLogRecord encontre un CheckPointEndLogRecord, entonces
					 * en este punto del log se que todas las transacciones activas terminaron o fueron
					 * abortadas y por ende no es necesario seguir revisando el log
					 */
					checkPoinEndFound = false;		//no es necesario, es solo para mantener consistencia
					break;

				// USELESS CHECKPOINT START RECORD?
				} else if (currentElem instanceof CheckPointStartLogRecord && !checkPoinEndFound)
				{
					/*
					 * Estoy en un CheckPointStartLogRecord pero no tiene su correspondiente 
					 * CheckPointEndLogRecord, de modo que no me sirve de nada este item, 
					 * tengo que seguir viendo el log
					 */
					continue;

				// CHECKPOINT END RECORD?					
				} else if (currentElem instanceof CheckPointEndLogRecord)
				{
					/*
					 * Encontre un CheckPointEnd, de modo que si al primer CheckPointStart que encuentre,
					 * estoy en condiciones de para y dejar de recorrer el log
					 */
					checkPoinEndFound = true;
				} else
				{
					result.addItem("ERROR: Item no reconocido : " + currentElem.toString());
					continue;
				}
		}
		
		return result;
		
	}
	//[end]
}
