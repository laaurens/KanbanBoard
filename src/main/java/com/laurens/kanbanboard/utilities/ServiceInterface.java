package com.laurens.kanbanboard.utilities;

import java.util.List;

public interface ServiceInterface<E> {
	
	public E create(E e);
	
	public boolean update(E e);
	
	public void delete(E e);
	
	public E readOneById(long id);
	
	public List<E> readAll();

}
