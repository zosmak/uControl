<?php
        class Database
        {
            // Store the single instance of Database
            private static $m_pInstance;

	    private static $servername='localhost';
	    private static $username = 'id134248_base_dados_projeto';
	    private static $password ='id134248_base_dados_projeto';
	    private static $dbname = 'id134248_base_dados_projeto';
            private static $conn;
            

            // Private constructor to limit object instantiation to within the class
            private function __construct() 
	    {
            
		// Create connection
		    self::$conn = new mysqli(self::$servername, self::$username, self::$password, self::$dbname);
		// Check connection
		if (self::$conn->connect_error) {
		    die("Connection failed: " . self::$conn->connect_error);
		}
	    }

            // Getter method for creating/returning the single instance of this class
            public static function getInstance()
            {
                if (!self::$m_pInstance)
                {
                    self::$m_pInstance = new Database();
                }
                return self::$m_pInstance;
            }

            public function query($query)
            {
               return  self::$conn->query($query);
	    }

	    public function close()
	    {
		    self::$conn->close();
	    }

         }
?>