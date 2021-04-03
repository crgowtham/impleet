/*
Given a family tree for a few generations for the entire population and
two people write a routine that will find out if they are blood related. 
Siblings are blood related since they have the same parents. Cousins are blood related since one of their parents have the same parents etc. 
Design the data structure first and then write the routine.
*/

public Person {
	String name;
	Person[] parents;
	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Person)obj).name);
	}
}

public boolean find (Person p1, Person p2, Set<Person> visited) {
	if(p1.equals(p2)) return true;
	if(visited.contains(p1)) return false;
	visited.add(p1)
	for(Person p1Parent : p1.parents) {
		if(find(p1Parent, p2, visited)) return true;

		for(Person p2Parent : p2.parents) {
			if(find(p2Parent, p1Parent, visited)) return true;
		}
	}
	return false;
}
