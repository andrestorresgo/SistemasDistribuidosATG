namespace FormFactura
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            button1 = new Button();
            textBox1 = new TextBox();
            label1 = new Label();
            textBox2 = new TextBox();
            textBox3 = new TextBox();
            textBox4 = new TextBox();
            textBox5 = new TextBox();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            textBox6 = new TextBox();
            textBox7 = new TextBox();
            label6 = new Label();
            label7 = new Label();
            comboBox1 = new ComboBox();
            SuspendLayout();
            // 
            // button1
            // 
            button1.Location = new Point(67, 319);
            button1.Name = "button1";
            button1.Size = new Size(212, 29);
            button1.TabIndex = 0;
            button1.Text = "ObtenerFactura";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // textBox1
            // 
            textBox1.Location = new Point(67, 38);
            textBox1.Name = "textBox1";
            textBox1.Size = new Size(125, 27);
            textBox1.TabIndex = 1;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(211, 45);
            label1.Name = "label1";
            label1.Size = new Size(87, 20);
            label1.TabIndex = 2;
            label1.Text = "idAmbiente";
            label1.Click += label1_Click;
            // 
            // textBox2
            // 
            textBox2.Location = new Point(67, 71);
            textBox2.Name = "textBox2";
            textBox2.Size = new Size(125, 27);
            textBox2.TabIndex = 3;
            // 
            // textBox3
            // 
            textBox3.Location = new Point(67, 104);
            textBox3.Name = "textBox3";
            textBox3.Size = new Size(125, 27);
            textBox3.TabIndex = 4;
            // 
            // textBox4
            // 
            textBox4.Location = new Point(67, 137);
            textBox4.Name = "textBox4";
            textBox4.Size = new Size(125, 27);
            textBox4.TabIndex = 5;
            // 
            // textBox5
            // 
            textBox5.Location = new Point(67, 170);
            textBox5.Name = "textBox5";
            textBox5.Size = new Size(125, 27);
            textBox5.TabIndex = 6;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(211, 78);
            label2.Name = "label2";
            label2.Size = new Size(32, 20);
            label2.TabIndex = 7;
            label2.Text = "NIT";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(211, 111);
            label3.Name = "label3";
            label3.Size = new Size(38, 20);
            label3.TabIndex = 8;
            label3.Text = "cufd";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(211, 144);
            label4.Name = "label4";
            label4.Size = new Size(82, 20);
            label4.TabIndex = 9;
            label4.Text = "modalidad";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(211, 177);
            label5.Name = "label5";
            label5.Size = new Size(88, 20);
            label5.TabIndex = 10;
            label5.Text = "razon social";
            // 
            // textBox6
            // 
            textBox6.Location = new Point(67, 203);
            textBox6.Name = "textBox6";
            textBox6.Size = new Size(125, 27);
            textBox6.TabIndex = 11;
            // 
            // textBox7
            // 
            textBox7.Location = new Point(67, 236);
            textBox7.Name = "textBox7";
            textBox7.Size = new Size(125, 27);
            textBox7.TabIndex = 12;
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(211, 210);
            label6.Name = "label6";
            label6.Size = new Size(110, 20);
            label6.TabIndex = 13;
            label6.Text = "numero factura";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(211, 243);
            label7.Name = "label7";
            label7.Size = new Size(109, 20);
            label7.TabIndex = 14;
            label7.Text = "nombre cliente";
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Items.AddRange(new object[] { "Us", "Eu" });
            comboBox1.Location = new Point(523, 62);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(151, 28);
            comboBox1.TabIndex = 15;
            comboBox1.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(comboBox1);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(textBox7);
            Controls.Add(textBox6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(textBox5);
            Controls.Add(textBox4);
            Controls.Add(textBox3);
            Controls.Add(textBox2);
            Controls.Add(label1);
            Controls.Add(textBox1);
            Controls.Add(button1);
            Name = "Form1";
            Text = "Form1";
            Load += Form1_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button button1;
        private TextBox textBox1;
        private Label label1;
        private TextBox textBox2;
        private TextBox textBox3;
        private TextBox textBox4;
        private TextBox textBox5;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private TextBox textBox6;
        private TextBox textBox7;
        private Label label6;
        private Label label7;
        private ComboBox comboBox1;
    }
}