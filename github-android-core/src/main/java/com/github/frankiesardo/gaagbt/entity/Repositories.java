package com.github.frankiesardo.gaagbt.entity;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Repositories implements List<Repository> {

    private final List<Repository> repositories;

    public Repositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    @Override
    public int size() {
        return repositories.size();
    }

    @Override
    public boolean isEmpty() {
        return repositories.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return repositories.contains(o);
    }

    @Override
    public Iterator<Repository> iterator() {
        return repositories.iterator();
    }

    @Override
    public Object[] toArray() {
        return repositories.toArray();
    }

    @SuppressWarnings("SuspiciousToArrayCall")
    @Override
    public <T> T[] toArray(T[] ts) {
        return repositories.toArray(ts);
    }

    @Override
    public boolean add(Repository repository) {
        return repositories.add(repository);
    }

    @Override
    public boolean remove(Object o) {
        return repositories.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> objects) {
        return repositories.containsAll(objects);
    }

    @Override
    public boolean addAll(Collection<? extends Repository> repositories) {
        return this.repositories.addAll(repositories);
    }

    @Override
    public boolean addAll(int i, Collection<? extends Repository> repositories) {
        return this.repositories.addAll(i, repositories);
    }

    @Override
    public boolean removeAll(Collection<?> objects) {
        return repositories.removeAll(objects);
    }

    @Override
    public boolean retainAll(Collection<?> objects) {
        return repositories.retainAll(objects);
    }

    @Override
    public void clear() {
        repositories.clear();
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object o) {
        return repositories.equals(o);
    }

    @Override
    public int hashCode() {
        return repositories.hashCode();
    }

    @Override
    public Repository get(int i) {
        return repositories.get(i);
    }

    @Override
    public Repository set(int i, Repository repository) {
        return repositories.set(i, repository);
    }

    @Override
    public void add(int i, Repository repository) {
        repositories.add(i, repository);
    }

    @Override
    public Repository remove(int i) {
        return repositories.remove(i);
    }

    @Override
    public int indexOf(Object o) {
        return repositories.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return repositories.lastIndexOf(o);
    }

    @Override
    public ListIterator<Repository> listIterator() {
        return repositories.listIterator();
    }

    @Override
    public ListIterator<Repository> listIterator(int i) {
        return repositories.listIterator(i);
    }

    @Override
    public List<Repository> subList(int i, int i2) {
        return repositories.subList(i, i2);
    }
}
