package application;

public class Snode {
	 /**
	  * @author LoginCs
	  *
	  */
	 Object data;
	 /**
	  * @author LoginCs
	  *
	  */
    Snode next;
    /**
	* @author LoginCs
	* @param  d data
	*/
    Snode(final Object d)  {	 
    data = d;
    next = null;
    }
}
