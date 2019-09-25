package application;

public class Search {
		
		public LinkedList BinarySearch(LinkedList R,String x,String type/*,String nodeType*/) {
			LinkedList newList = new LinkedList();
			int left = 0;
			int right = R.size()-1;
			int mid;
			while(left <= right) {
				mid = (left + right)/2;
				String current = new String();
				//if(nodeType.equals("MailNode")){
				MailNode temp = new MailNode();
				temp = (MailNode) R.get(mid);
				if(type.equals("Subject")) {
					current = temp.getSubject();
				}
				else if(type.equals("Sender's Name")) {
					current = temp.getFrom();
				}
				else if(type.equals("Receiver's Name")) {
					current = temp.getTo();
				}
				else if(type.equals("First Name")) {
					current = temp.getFirstName();
				}
				else if(type.equals("Last Name")) {
					current = temp.getLastName();
				}
				else if(type.equals("Relation")) {
					current = temp.getRelation();
				}
				if(current.equalsIgnoreCase(x)) {
					newList.add(temp);
					int size = R.size();
					if(size == 1) {
						R.clear();
					}
					else {
					R.remove(mid);
					}
					left = 0;
					if(size == 1) {
						return newList;
					}
					if(R.size() > 1) {
					right = R.size() - 1;
					}
					else if(R.size() == 1) {
						MailNode temp2 = new MailNode();
						temp2 = (MailNode) R.get(0);
						if(type.equals("Subject")) {
							current = temp2.getSubject();
						}
						else if(type.equals("Sender's Name")) {
							current = temp2.getFrom();
						}
						else if(type.equals("Receiver's Name")) {
							current = temp2.getTo();
						}
						else if(type.equals("First Name")) {
							current = temp2.getFirstName();
						}
						else if(type.equals("Last Name")) {
							current = temp2.getLastName();
						}
						if(current.compareTo(x) == 0) {
							newList.add(temp);
						}
						return newList;
					}
					else {
						return newList;
					}
				}
				else if (current.compareTo(x)>0) {
					right = mid-1;
				}
				else if (current.compareTo(x)<0) {
					left = mid + 1;
				}
			}
			return newList;
		}
		public LinkedList normalSearch(LinkedList l,String x,String type) {
			LinkedList newList = new LinkedList();
			for(int i = 0; i < l.size(); i++ ) {
				MailNode temp = (MailNode) l.get(i);
				String current = new String();
				if(type.equals("Subject")) {
					current = temp.getSubject();
				}
				else if(type.equals("Sender's Name")) {
					current = temp.getFrom();
				}
				else if(type.equals("Receiver's Name")) {
					current = temp.getTo();
				}
				if(current.compareTo(x)==0) {
					newList.add(temp);
				}
			}
			return newList;
		}
		
	}

