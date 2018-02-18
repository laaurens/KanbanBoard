package com.laurens.kanbanboard.utilities;

import java.util.List;

public interface JPACRUDInterface<E> {

	public E create(E e);

	public boolean update(E e);

	public void deleteById(E e);

	public E readOneById(long id);

	public List<E> readAll();

}
