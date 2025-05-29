#!/bin/bash

# Create necessary directories
sudo mkdir -p /var/www/vehicrent/static
sudo mkdir -p /var/www/vehicrent/uploads

# Copy static files
sudo cp -r ../src/main/resources/static/* /var/www/vehicrent/static/

# Set proper permissions
sudo chown -R www-data:www-data /var/www/vehicrent
sudo chmod -R 755 /var/www/vehicrent

# Install Certbot for SSL
sudo apt-get update
sudo apt-get install -y certbot python3-certbot-nginx

# Get SSL certificate
sudo certbot --nginx -d ctsmadeit.tech -d www.ctsmadeit.tech

# Copy Nginx configuration
sudo cp ctsmadeit.tech.conf /etc/nginx/sites-available/ctsmadeit.tech
sudo ln -s /etc/nginx/sites-available/ctsmadeit.tech /etc/nginx/sites-enabled/
sudo rm -f /etc/nginx/sites-enabled/default

# Test Nginx configuration
sudo nginx -t

# Restart Nginx
sudo systemctl restart nginx

# Create service file for Spring Boot application
sudo tee /etc/systemd/system/vehicrent.service << EOF
[Unit]
Description=VehicRent Spring Boot Application
After=network.target

[Service]
Type=simple
User=ubuntu
WorkingDirectory=/home/ubuntu/VehicRent
ExecStart=/usr/bin/java -jar target/vehicrent-0.0.1-SNAPSHOT.jar
Restart=always

[Install]
WantedBy=multi-user.target
EOF

# Reload systemd and start service
sudo systemctl daemon-reload
sudo systemctl enable vehicrent
sudo systemctl start vehicrent

echo "Setup completed!" 